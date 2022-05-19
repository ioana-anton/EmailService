package com.example.emailservice;
import com.example.emailservice.DTO.RegisterEmailDTO;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
//@Configuration
public class RegisterQueueConsumer {
//       // @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
//       @RabbitListener(queues = "register-orders")
//        public void recievedMessage(RegisterEmailDTO msg) {
//            System.out.println("Received Message From RabbitMQ: " + msg.getEmail());
//        }

}
