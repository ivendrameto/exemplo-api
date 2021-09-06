package br.com.deal.estagio.agosto.nid.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long userId;

    private String name;
    private String nickname;

    private Boolean active;
    private Boolean blocked;

}
