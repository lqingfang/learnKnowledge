package org.lqf.learn.designModel.mediatorModel;

public enum ActionEnum {
    HUNT("做好了饭","来吃饭"),
    TALE("要讲故事","来听故事"),
    FOND("发现了鲜花","来观赏");

    private String title;
    private String description;

    ActionEnum(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public String toString() {
        return title;
    }
}
