- https://martinfowler.com/bliki/UnitTest.html
- https://martinfowler.com/articles/practical-test-pyramid.html
- https://www.youtube.com/watch?v=lXTwxMxNx-Y
- https://assertj.github.io/doc/
- https://www.archunit.org/userguide/html/000_Index.html
- [Test-driven development TDD - Kent Beck](https://www.amazon.com.br/Test-Driven-Development-Kent-Beck/dp/0321146530/ref=asc_df_0321146530/?tag=googleshopp00-20&linkCode=df0&hvadid=379787788238&hvpos=&hvnetw=g&hvrand=5049899637757719844&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1001590&hvtargid=pla-448095042394&psc=1)

## Alguns questionamentos:

### Por que testar?

### O que é testável dentro do teste unitário?

----------------------------------------------
### Teste end to end (automatizado, manual)
    - Teste do fluxo inteiro da aplicação
    - Acessando banco de dados, microserviços, etc
    - Responde às mudanças de comportamento.
    - Testa inclusive a conversação entre serviços
    - Teste do fluxo inteiro da aplicação visando o comportamento funcional e regras de negócio
    - Não há a necessidade de conhecer a estrutura interna da aplicação (código) (teste de caixa preta)
    - São os testes mais caros, pois podem quebrar com maior facilidade e levam mais tempo para executar

### Teste integrado de backend
    - Testa todos os métodos integrados
    - Não acessa serviços externos
    - Responde às mudanças de comportamento.
    - Pode acessar o banco de dados

### Testes unitários
    - Interessado em testar uma unidade pequena
    - É um teste de algoritmo
    - Não acessa integrações externas e nem o banco de dados
    - Responde às mudanças de comportamento.
    - Execute de forma confiável.
    - Minimize a espera do programador.

### Teste de arquitetura
    - Responde a mudanças de estrutura ou seja garante que o padrão de arquitetura da aplicação não seja quebrado.
    - Não responde às mudanças de comportamento.
    - Execute de forma confiável.
    - Minimize a espera do programador.
    - Facilita code review
