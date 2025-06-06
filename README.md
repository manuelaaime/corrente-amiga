# Corrente Amiga - Sistema de Doações

>API REST para gestão de doações desenvolvida em Java 17 com Spring Boot. 
<br>
>>Ideal para ONGs, instituições de caridade ou iniciativas sociais que desejam otimizar o processo de doações e fortalecer a corrente do bem!

##  ✨ Funcionalidades

- Cadastro e gerenciamento de doadores e beneficiários
- Registro e acompanhamento de doações realizadas
- Integração com Swagger para documentação interativa da API

##  🛠 Tecnologias Utilizadas

- ![Java](https://img.shields.io/badge/Java-17-blue)
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-green)
- ![Maven](https://img.shields.io/badge/Maven-3.8-red)
- ![Swagger](https://img.shields.io/badge/Swagger-3.0-lightgreen)
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
- ![Insomnia](https://img.shields.io/badge/Insomnia-2023-purple)
  



## Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/corrente-amiga.git
   ```

2. **Navegue até o diretório do projeto:**
   ```bash
   cd corrente-amiga
   ```

## 📚 Documentação da API
   Essa  API está totalmente documentada com Swagger. 
   <br> Acesse a interface interativa em:

- http://localhost:8080/swagger-ui.html
## Endpoints Principais

- `/doacoes` - Gerenciamento de Doações
- `/doador` - Gerenciamento de Doador
- `/instituicoes` - Registro e consulta de Instituições

## 🗃️ Banco de Dados Avançado
O sistema utiliza um banco de dados relacional com recursos avançados para otimização e regras de negócio:

### Principais Recursos Implementados

**Views Estratégicas:**
- `vw_area_mais_investida` - Filtra as áreas com mais doações

**Triggers Automatizados:**
- `trg_verificar_valor_doacao` - Aplica regras de validação antes de inserir doações

**Consulta Simples:**

- Relatório de doadores mais ativos: 
```sql

SELECT
    d.id_doacao,
    i.NOME_INSTITUICAO,
    d.VALOR_DOACAO
FROM
    doacao d
JOIN
    instituicao i ON d.instituicao_id = i.ID_INSTITUICAO
WHERE
    d.VALOR_DOACAO > 500;
```

## 🌱 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

---
