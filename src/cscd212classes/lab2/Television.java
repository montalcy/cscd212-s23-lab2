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
        if(make==null||model==null||screenSize<32||resolution<720)
            throw new IllegalArgumentException("Invalid parameter in constructor");
        if(resolution==2160)
            this.fourK=true;
        else
            this.fourK=false;
        this.make=make;
        this.model=model;
        this.smart=smart;
        this.screenSize=screenSize;
        this.resolution=resolution;
    }

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make){
       this(make, model, smart, screenSize, resolution);
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
        String smart;
        if(this.smart==true)
            smart=" smart";
        else
            smart="";
        String four;
        if(this.fourK==true)
            four="4K";
        else
            four=""+this.resolution;
        return this.getMake()+"-"+this.getModel()+", "+this.getScreenSize()+" inch"+smart+" tv with "+four+" resolution";
    }
    @Override
    public boolean equals(final Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television tv = (Television) o;
        return Objects.equals(this.make, tv.getMake())&& Objects.equals( this.model, tv.getModel())&&Objects.equals(this.smart, tv.smart)&&Objects.equals(this.screenSize, tv.getScreenSize())&&Objects.equals(this.resolution, tv.getResolution());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getMake(), this.getModel(), this.smart, this.getScreenSize(), this.getResolution());
    }

    @Override
    public int compareTo(final Television another){
        if(another==null)
            throw new IllegalArgumentException("null parameter in the compareTo method");
        if(this.getMake().compareTo(another.getMake())==0){
            if(this.getModel().compareTo(another.getModel())==0){
                return this.getScreenSize()-(another.getScreenSize());
            }
            return this.getModel().compareTo(another.getModel());
        }
        return this.getMake().compareTo(another.getMake());
    }

}
