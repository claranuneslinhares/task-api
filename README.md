# taskapi
Aluno(a): Maria Clara Nunes

Resposta atividade: 
### Parte A — Identificação do vazamento de Entity
No primeiro trecho, o campo que não deveria estar visível é `senhaHash`, pois representa uma informação relacionada à segurança e não deve ser exposta ao consumidor da API. A exposição desse dado pode representar um risco de segurança. No segundo trecho, o campo `auditoria` não deveria ser retornado, pois contém informações internas da aplicação. Sua exposição pode aumentar o acoplamento entre o consumidor da API e a implementação interna do sistema. No terceiro trecho, o campo `versaoOtimista` também não deveria ser exposto, pois representa uma informação interna que não é necessária para o consumidor da API e pode causar confusão.
Para evitar esses problemas, pode ser criado um `TaskResponseDTO` contendo somente os dados que realmente devem ser disponibilizados pela API, como `id`, `titulo`, `concluida` e `prioridade`.

