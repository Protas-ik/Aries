package com.example.aries.controller;


import com.example.aries.domain.Order;
import com.example.aries.domain.OrderStatus;
import com.example.aries.domain.Role;
import com.example.aries.domain.User;
import com.example.aries.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {
    @Autowired
    private OrderRepo orderRepo;

    @PostMapping("/addOrder")
    public String addOrder(
            @RequestParam String markOfCar,
            @RequestParam String modelOfBody,
            @RequestParam String vinNumber,
            @RequestParam String nameOfOwner,
            @RequestParam String surnameOfOwner,
            @RequestParam String orderPhoneNumber,
            @RequestParam String carMileage,
            @RequestParam String description,
            @AuthenticationPrincipal User user,
            Model model
    ) {
        /*if(user.getRoles().contains(Role.ADMINISTRATOR) || user.getRoles().contains(Role.DIRECTOR)){
            model.addAttribute("orders", orderRepo.findAll());
        } else {

        }*/
        Order newOrder = new Order();
        newOrder.setOrderOwnerId(user.getId());
        newOrder.setMarkOfCar(markOfCar);
        newOrder.setModelOfBody(modelOfBody);
        newOrder.setVinNumber(vinNumber);
        newOrder.setNameOfOwner(nameOfOwner);
        newOrder.setSurnameOfOwner(surnameOfOwner);
        newOrder.setOrderPhoneNumber(orderPhoneNumber);
        newOrder.setCarMileage(carMileage);
        newOrder.setDescription(description);
        newOrder.setOrderStatusForClient(OrderStatus.TAKEN);
        newOrder.setOrderStatusForService(OrderStatus.TAKEN);
        orderRepo.save(newOrder);
        if(user.getRoles().contains(Role.ADMINISTRATOR) || user.getRoles().contains(Role.WORKER) || user.getRoles().contains(Role.DIRECTOR)){
            model.addAttribute("orders", orderRepo.findAll());
        } else {
            model.addAttribute("orders", orderRepo.findOrderByOrderOwnerId(user.getId()));
        }
        return "orders";
    }

    @PostMapping("/ordersByOwnerId")
    public String showOrderById(@RequestParam String ownerIdToFindOrders, Model model){
        if(!ownerIdToFindOrders.isBlank()){
            model.addAttribute("orders", orderRepo.findOrderByOrderOwnerId(Long.parseLong(ownerIdToFindOrders)));
        }
        model.addAttribute("orders", orderRepo.findAll());
        return "orders";
    }

    @GetMapping("/orders")
    public String showOrders(@AuthenticationPrincipal User user, Model model){
        if(user.getRoles().contains(Role.ADMINISTRATOR) || user.getRoles().contains(Role.DIRECTOR) || user.getRoles().contains(Role.WORKER)){
            model.addAttribute("orders", orderRepo.findAll());
        } else {
            model.addAttribute("orders", orderRepo.findOrderByOrderOwnerId(user.getId()));
        }
        return "orders";
    }

    @GetMapping("/order/delete/{order}")
    public String deleteOrder(@PathVariable Order order, Model model){
        orderRepo.deleteById(order.getId());
        model.addAttribute("orders", orderRepo.findAll());
        return "orders";
    }

    @GetMapping("/order/edit/{order}")
    public String editOrder(@PathVariable Order order, Model model){
        model.addAttribute("employer", order);
        return "editOrder";
    }

    @GetMapping("/order/info/{order}")
    public String infoOrder(@PathVariable Order order, Model model){
        model.addAttribute("order", order);
        return "description";
    }

    @PostMapping("/order_save_after_redirect_for_client")
    public String employerSaveForClient(
            @RequestParam String orderStatusAfterEdit,
            @RequestParam("orderId") Order order,
            Model model
    ) {
        OrderStatus orderStatus;
        if(orderStatusAfterEdit.equals("READY")){
            orderStatus = OrderStatus.READY;
        } else if(orderStatusAfterEdit.equals("IN_PROGRESS")){
            orderStatus = OrderStatus.IN_PROGRESS;
        } else if(orderStatusAfterEdit.equals("TAKEN")){
            orderStatus = OrderStatus.TAKEN;
        } else {
            orderStatus = OrderStatus.NOT_READY;
        }
        order.setOrderStatusForClient(orderStatus);

        orderRepo.save(order);

        model.addAttribute("orders", orderRepo.findAll());
        return "orders";
    }

    @PostMapping("/order_save_after_redirect_for_Employers")
    public String employerSaveForEmployers(
            @RequestParam String orderStatusAfterEdit,
            @RequestParam("orderId") Order order,
            Model model
    ) {
        OrderStatus orderStatus;
        if(orderStatusAfterEdit.equals("READY")){
            orderStatus = OrderStatus.READY;
        } else if(orderStatusAfterEdit.equals("IN_PROGRESS")){
            orderStatus = OrderStatus.IN_PROGRESS;
        } else if(orderStatusAfterEdit.equals("TAKEN")){
            orderStatus = OrderStatus.TAKEN;
        } else {
            orderStatus = OrderStatus.NOT_READY;
        }
        order.setOrderStatusForService(orderStatus);

        orderRepo.save(order);

        model.addAttribute("orders", orderRepo.findAll());
        return "orders";
    }
}
