Sitema de cadastro de beneficíarios do Plano de Saúde. Desenvolvido em Java 17 com SpringBoot 3.0.6 e banco de dados embarcado H2 com gravação no disco, e Maven 3.0.6. Foram aplicados conceitos de arquitetura limpa e hexagonal, visando a escalabilidade e implantação de serviço de mensageria com kafka. Possui testes utilizando JUnit e Mockito. Api segura atarvés do uso de JWT. Documentação no Swagger / OpenApi, com a função de autorização habilitada.

Para executar e testar os endpoints, siga os passos:

- Clone o repositório;
- No terminal, vá até a pasta raiz do projeto e execute o comando `mvn clean install`. Serão instaladas as dependências do projeto e os testes serão executados;
- Ainda no terminal, vá até a pasta `[pasta_raiz]/beneficiario-service/beneficiario-container` e execute o comando `mvn spring-boot:run`;
- Ao ver a mensagem `Started BeneficiarioServiceApplication in ### seconds (process running for ###)`, saberá que o sistema está no ar;
- No navegador, acesse o endereço `http://localhost:8080/swagger-ui/index.html#/`;
- No swagger haverá a lista de endpoints, faça o cadastro de um usuário acessando `/usuario/criar`, siga o modelo Json ali proposto. Para o campo `role`, entre com o valor `ROLE_ATENDENTE` ou `ROLE_FINANCEIRO`. Faça ao menos um usuário para cada `role`, pois alguns endpoints são exclusivos a cada um deles.
- Faça o login no endpoint `/usuario/login`. A reposta da requisição virá com o bearer token de acesso à api. Apenas esses dois endpoints no caminho `/usuario` não são protegidos;
- Copie o bearer token para a área de transferência e no swagger - no canto superior direito - clique no botão `Authorize`, com o ícone de um cadeado. Na caixa de diálogo que será aberta, cole o bearer token no campo `value` e clique no botão `Authorize`. Então suas requisições incluirão o token no cabeçalho, permitindo o acesso aos endpoints do caminho `/beneficiario`;
- As funções possíveis são:
	- listar todos os beneficiários (`ROLE_FINANCEIRO / ROLE_ATENDENTE`);
	- cadastrar beneficiário (`ROLE_FINANCEIRO`);
	- listar todos os documentos de um beneficiário, obtido por id (`ROLE_ATENDENTE`);
	- atualizar os dados de um beneficiário (`ROLE_ATENDENTE`);
	- remover beneficiário por id (`ROLE_FINANCEIRO`);
