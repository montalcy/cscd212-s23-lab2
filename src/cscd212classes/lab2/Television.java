package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String make, final String model, final  boolean smart, final int screenSize,final int resolution){
        if(make.isBlank()||model.isBlank()||make==null||model==null||screenSize<32||resolution<720)
            throw new IllegalArgumentException("Please check input");
        if(resolution==2160)
            this.fourK=true;
        this.make=make;
        this.model=model;
        this.smart=smart;
        this.screenSize=screenSize;
        this.resolution=resolution;
    }

    public Television(String model, boolean smart, int screenSize, int resolution, String make){
        Television tv=new Television(make, model, smart, screenSize, resolution);
    }

    public int getScreenSize(){
        return this.screenSize;
    }

    public int getResolution(){
        return this.resolution;
    }

    public String getMake(){
        return this.make;
    }
    public String getModel(){
        return this.model;
    }
    @Override
    public String toString(){
        String hold=this.getMake()+","+this.getModel()+" inch";
        if(fourK==true)
            hold=hold+" smart tv with 4K resolution";
        else
            hold=hold+" tv with "+resolution+"resolution";
        return hold;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television tv = (Television) o;
        return Objects.equals(make, tv.getMake())&& Objects.equals( model, tv.getModel())&&Objects.equals(smart, tv.smart)&&Objects.equals(screenSize, tv.getScreenSize())&&Objects.equals(resolution, tv.getResolution());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getMake(), getModel(), this.smart, getScreenSize(), getResolution());
    }
    @Override
    public int compareTo(Television another){
        if(another==null)
            throw new IllegalArgumentException("Illegal arg for compareTo");
        if(this.getMake().compareTo(another.getMake())==0){
            if(this.getModel().compareTo(another.getModel())==0){
                return this.getScreenSize()-(another.getScreenSize());
            }
            return this.getModel().compareTo(another.getModel());
        }
        return this.getModel().compareTo(another.getModel());
    }

}
