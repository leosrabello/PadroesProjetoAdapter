O projeto usa o padrão **Adapter** para padronizar o acesso a diferentes APIs de redes sociais.  
Cada API tem seu próprio jeito de funcionar, então foram criados adaptadores (por exemplo, `TwitterAdapter` e `InstagramAdapter`) que “traduzem” essas diferenças para uma interface única chamada `Plataforma`.  
Assim, o sistema consegue publicar, agendar e buscar estatísticas sem precisar conhecer os detalhes de cada API.

