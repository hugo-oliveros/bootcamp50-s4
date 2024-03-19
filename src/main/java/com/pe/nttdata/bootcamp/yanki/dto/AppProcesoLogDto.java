package com.pe.nttdata.bootcamp.yanki.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AppProcesoLogDto {

    private Date fechaInicioEjecucion;
    private Date fechaFinEjecucion;
    private String estadoEjecucion;
    private String descripcionEstadoEjecucion;
    private String modulo;
    private String claseProgramacion;
    private String metodoProgramacion;
    private String parametroEntrada;
    private String resultadoSalida;
    private Integer duracionMs;

}
