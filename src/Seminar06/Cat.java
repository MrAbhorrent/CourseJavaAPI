package Seminar06;

public class Cat {
    private String nickname;
    private String color;
    private int age;
    private final Sex sex;

    public Cat(String nickname, String color, int age, Sex sex) {
        this.nickname = nickname;
        this.color = color;
        setAge(age);
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <=25) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Не корректно указан возраст");
        }
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "nickname='" + nickname + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}' + "\n";
    }
}
