package Exercises;

public class Hero {
    String name;
    int age;
    String skill;
    int level;
    float hp;
    public int moveSpeed;
    public float armor;

    public Hero(String name, int age, String skill, int level) {
        this.name = name;
        this.age = age;
        this.level = level;
        this.skill = skill;
    }

    public void legnedary() {
        System.out.println("英雄" + name + "，年龄" + age + "，技能" + skill + "，等级" + level + "，是一个传奇英雄！");
    }

    public float getHp() {
        return hp;
    }

    public void recovery (float blood) {
        System.out.println(name + "恢复了" + blood + "点血量。");
    }
}
