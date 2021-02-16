# Spring reactive com resilience4j
- Quando uma aplicação começa a ficar lenta ou a falhar, um circuit breaker pode ser usado para interromper toda a comunicação com essa aplicação.
- Seu funcionamento é simples:
  - quando acionado, o fluxo original não será utilizado e sim um alternativo.
  - tempos em tempos, o circuit breaker verifica a saúde do fluxo original, caso esteja ok, o circuito fica meio aberto (parte das chamadas caem no fluxo orignal e alternativo)
  - se nenhuma falha for idenficada no fluxo original, nesse tempo, o circuit breaker é fechado e as chamadas voltam exclusivamente para o fluxo original, caso contrário, fica aberto e interrompe as chamdas para o fluxo original.
