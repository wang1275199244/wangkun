package com.wk.model;

import java.io.Serializable;

public class TrainFand implements Serializable {
    private Train train;
    private Employee employee;
    private Position position;
    private Department department;

    public TrainFand() {
    }

    public TrainFand(Employee employee, Position position, Department department) {
        this.employee = employee;
        this.position = position;
        this.department = department;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "TrainFand{" +
                "train=" + train +
                ", employee=" + employee +
                ", position=" + position +
                ", department=" + department +
                '}';
    }
}
