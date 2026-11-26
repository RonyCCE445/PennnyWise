package io.github.ronycce445.pennywise.dto;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ApiErrorResponse {
   private LocalDateTime timestamp;
   private int status;
   private String error;
   private  String message;
   private Map<String, String> details;
}
