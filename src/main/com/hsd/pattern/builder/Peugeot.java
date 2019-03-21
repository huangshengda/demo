package main.com.hsd.pattern.builder;

/**
 * @Author:huangshengda
 * @Description:
 * @Date: 2019/1/13
 */
public class Peugeot {

    private String name;
    private int age;
    private String country;

    public static class Builder{
        private String name;
        private int age;
        private String country;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder country(String country) {
            this.country = country;
            return this;
        }
        public Peugeot build(){
            return new Peugeot(this);
        }
    }

    private Peugeot(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.country = builder.country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public static void main(String[] args){
        Peugeot peugeot = new Peugeot.Builder().age(1).name("308").build();
    }

}
