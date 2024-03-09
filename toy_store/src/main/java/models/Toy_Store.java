package models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


public class Toy_Store {
    private int id_factura;
    private String empresa;
    private Date fecha_compra;
    private int id_cliente;
    private int id_empleado;
    private int toy_id;

}
