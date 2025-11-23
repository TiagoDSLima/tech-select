package com.br.tggp.techselect.service;

import com.br.tggp.techselect.dto.SkillResponse;
import com.br.tggp.techselect.enums.Apto;
import com.br.tggp.techselect.enums.NivelSkill;
import com.br.tggp.techselect.model.Candidatura;
import com.br.tggp.techselect.model.Skill;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvaliadorDeCandidatura {

    private List<String> skillsCandidatura;
    private List<String> skillsObrigatorias;
    private List<String> skillsDesejaveis;

    public Apto avaliacaoCandidatura(Candidatura candidatura) {

        preencheSkills(candidatura);
        boolean naoPossuiObrigatorias = !skillsCandidatura.containsAll(skillsObrigatorias);
        boolean naoTemExperienciaNecessaria = candidatura.getExp() < candidatura.getVaga().getExpMin();

        if (naoPossuiObrigatorias) {
            return Apto.INAPTO;
        } else if (naoTemExperienciaNecessaria) {
            return Apto.INAPTO;
        } else {
            long qtdSkillDesejaveisCandidato = skillsDesejaveis.stream()
                    .filter(skillsCandidatura::contains)
                    .count();

            boolean vagaComUmaSkillDesejavel = skillsDesejaveis.size() == 1;
            boolean temPeloMenosDuasSkillDesejaveis = qtdSkillDesejaveisCandidato >= 2;
            boolean candidatoTemUmaSkillDesejavel = qtdSkillDesejaveisCandidato == 1;

            if (vagaComUmaSkillDesejavel && candidatoTemUmaSkillDesejavel) {
                return Apto.MUITO_APTO;
            } else if (!vagaComUmaSkillDesejavel && temPeloMenosDuasSkillDesejaveis) {
                return Apto.MUITO_APTO;
            } else {
                return Apto.APTO;
            }
        }
    }

    public void preencheSkills(Candidatura candidatura){
        skillsCandidatura = candidatura.getSkills().stream()
                .map(Skill::getDescricao)
                .toList();
        skillsObrigatorias = candidatura.getVaga().getSkills().stream()
                .filter(skill -> NivelSkill.OBRIGATORIA.equals(skill.getNivel()))
                .map(Skill::getDescricao)
                .toList();
        skillsDesejaveis = candidatura.getVaga().getSkills().stream()
                .filter(skill -> NivelSkill.DESEJAVEL.equals(skill.getNivel()))
                .map(Skill::getDescricao)
                .toList();
    }
}
