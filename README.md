# Spring reactive com resilience4j
- Quando uma aplicação começa a ficar lenta ou a falhar, um circuit breaker pode ser usado para interromper toda a comunicação com essa aplicação.
- Seu funcionamento é simples:
  - quando acionado, o fluxo original não será utilizado e sim um alternativo.
  - tempos em tempos, o circuit breaker verifica a saúde do fluxo original, caso esteja ok, o circuito fica meio aberto (parte das chamadas caem no fluxo orignal e alternativo)
  - se nenhuma falha for idenficada no fluxo original, nesse tempo, o circuit breaker é fechado e as chamadas voltam exclusivamente para o fluxo original, caso contrário, fica aberto e interrompe as chamdas para o fluxo original.


# Uso do retry do spring
- Não da suporte a programação reactive.
- A aplicação de exemplo, segue as regras abaixo:
  - @EnableRetry: habilitar o uso do recurso na aplicação.
  - @Retryable: Esta é a anotação principal depois de @EnableRetry. Esta anotação diz-nos que se obtivermos uma RemoteServiceNotAvailableException do método, tentamos novamente mais três vezes antes de enviarmos a resposta de resposta de recurso. Também estamos a introduzir um atraso de um segundo em cada nova tentativa.
  - @Recover: Esta anotação de fallback indica que se não obtivermos qualquer resposta bem sucedida após três tentativas, a resposta virá deste método de fallback. Certifique-se de que passa a excepção esperada como parâmetro ou então a Primavera terá dificuldade em encontrar o método exacto.
