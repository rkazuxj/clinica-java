public class Exame {
    private String medico;
    private String paciente;
    private String especialidade;
    private String cpf;
   private String crm;

    public void Consulta(String medico, String paciente, String especialidade, String cpf, String crm) {
        this.especialidade = especialidade;
        this.medico = medico;
        this.crm = crm;
        this.paciente = paciente;
        this.cpf = cpf;
    }

    public String getMedico() {
        return medico;
    }
    public String getPaciente() {
        return paciente;
    }

    public String getEspecialidade() { 
        return  especialidade;
    }

    public String getCPF(){
        return cpf;
    }
    
    public String getCRM(){
        return crm;
    }

    public void setMedico(String medico){
        this.medico = medico;
    }

    public void setPaciente(String paciente){
        this.paciente = paciente;
    }
    
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public void setCRM(String crm){
        this.crm = crm;
    }
}