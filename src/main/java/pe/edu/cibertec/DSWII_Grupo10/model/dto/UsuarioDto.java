package pe.edu.cibertec.DSWII_Grupo10.model.dto;

import lombok.Data;
@Data
public class UsuarioDto implements DtoEntity {
    private Integer usuarioid;
    private String usuarioname;
}
