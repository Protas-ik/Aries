package com.example.aries.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOfTakenOrder;

    private Long orderOwnerId;

    private OrderStatus orderStatusForClient = OrderStatus.NOT_READY;

    private OrderStatus orderStatusForService = OrderStatus.NOT_READY;

    @NotBlank(message = "Please fill the markOfCar")
    @Length(max = 32, message = "markOfCar too long")
    private String markOfCar;

    @NotBlank(message = "Please fill the modelOfBody")
    @Length(max = 32, message = "modelOfBody too long")
    private String modelOfBody;

    //regex
    @NotBlank(message = "Please fill the vinNumber")
    @Length(max = 64, message = "vinNumber too long")
    private String vinNumber;

    @NotBlank(message = "Please fill the nameOfOwner")
    @Length(max = 64, message = "nameOfOwner too long")
    private String nameOfOwner;

    @NotBlank(message = "Please fill the surnameOfOwner")
    @Length(max = 64, message = "surnameOfOwner too long")
    private String surnameOfOwner;

    @NotBlank(message = "Please fill the orderPhoneNumber")
    @Length(max = 64, message = "orderPhoneNumber too long")
    private String orderPhoneNumber;

    //regex
    @NotBlank(message = "Please fill the carMileage")
    @Length(max = 16, message = "carMileage too long")
    private String carMileage;

    @NotBlank(message = "Please fill the description")
    @Length(max = 1024, message = "description too long")
    private String description;

    public Order(){

    }

    public Order(Long id, Long orderOwnerId, Date dateOfTakenOrder, OrderStatus orderStatusForClient, OrderStatus orderStatusForService, String markOfCar,
                 String modelOfBody, String vinNumber, String nameOfOwner, String surnameOfOwner, String carMileage, String description) {
        this.id = id;
        this.orderOwnerId = orderOwnerId;
        this.dateOfTakenOrder = dateOfTakenOrder;
        this.orderStatusForClient = orderStatusForClient;
        this.orderStatusForService = orderStatusForService;
        this.markOfCar = markOfCar;
        this.modelOfBody = modelOfBody;
        this.vinNumber = vinNumber;
        this.nameOfOwner = nameOfOwner;
        this.surnameOfOwner = surnameOfOwner;
        this.carMileage = carMileage;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderOwnerId() {
        return orderOwnerId;
    }

    public void setOrderOwnerId(Long userOfOrderId) {
        this.orderOwnerId = userOfOrderId;
    }

    public Date getDateOfTakenOrder() {
        return dateOfTakenOrder;
    }

    public void setDateOfTakenOrder(Date dateOfTakenOrder) {
        this.dateOfTakenOrder = dateOfTakenOrder;
    }

    public OrderStatus getOrderStatusForClient() {
        return orderStatusForClient;
    }

    public void setOrderStatusForClient(OrderStatus orderStatusForClient) {
        this.orderStatusForClient = orderStatusForClient;
    }

    public OrderStatus getOrderStatusForService() {
        return orderStatusForService;
    }

    public void setOrderStatusForService(OrderStatus orderStatusForService) {
        this.orderStatusForService = orderStatusForService;
    }

    public String getMarkOfCar() {
        return markOfCar;
    }

    public void setMarkOfCar(String markOfCar) {
        this.markOfCar = markOfCar;
    }

    public String getModelOfBody() {
        return modelOfBody;
    }

    public void setModelOfBody(String modelOfBody) {
        this.modelOfBody = modelOfBody;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public String getSurnameOfOwner() {
        return surnameOfOwner;
    }

    public void setSurnameOfOwner(String surnameOfOwner) {
        this.surnameOfOwner = surnameOfOwner;
    }

    public String getOrderPhoneNumber() {
        return orderPhoneNumber;
    }

    public void setOrderPhoneNumber(String orderPhoneNumber) {
        this.orderPhoneNumber = orderPhoneNumber;
    }

    public String getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(String carMileage) {
        this.carMileage = carMileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
