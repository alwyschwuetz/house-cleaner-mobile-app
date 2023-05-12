package com.ebookfrenzy.project;

public class OnboardingItem
{
    private int animation;
    private String title, description;

    protected int getAnimation(){
        return animation;
    }
    public void setAnimation(int animation){
        this.animation = animation;
    }

    protected String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
