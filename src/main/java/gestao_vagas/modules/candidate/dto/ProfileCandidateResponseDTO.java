package gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {
    private UUID id;

    @Schema(example = "Maria de Souza")
    private String name;

    @Schema(example = "maria")
    private String username;

    @Schema(example = "maria@gmail.com")
    private String email;

    @Schema(example = "Desenvolvedora Java")
    private String description;
}
