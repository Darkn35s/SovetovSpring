package org.sadtech.example.swagger.Entities;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * @author upagge 30.12.2020
 */
@Schema(description = "Студент")
public class StudentEnt {

    @Schema(description = "Номер",example = "123")
    private String key;

    @Schema(description = "ФИО", example = "Джон Уик")
    private String name;

    @Schema(description = "Группа")
    private Group group;

    @Schema(description = "Пол")
    private Gender gender;

    @Schema(description = "Дата и время регистрации", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime regDate = LocalDateTime.now();

    public StudentEnt() {
    }

    public StudentEnt(String key, String name, Group group, Gender gender) {
        this.key = key;
        this.name = name;
        this.group = group;
        this.gender = gender;
    }


    public static StudentEnt of(String key, String value, Gender gender) {
        return new StudentEnt(key, value,Group.BSBO0118,gender);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }
}
