# Tecnologia em Análise e Desenvolvimento de Sistemas

2º Ano, 4º Bimestre - 2015 | 
[Univel](http://www.univel.br)
Discente: Danny Felipe de Mello
Docente: Fernando Dagostini

# Sistema
* O sistema de vendas, é um sistema genérico, podendo ser utilizado para qualquer finalidade de uma micro-empresa. 

Para acesso de usuário administrador deve se utilizar:

Usuário: admin | Senha: admin

## Configuração necessária
* Para a utilização do software o usuário deverá possuir em sua estação de trabalho alguns requisitos mínimos.

## Requisitos
Antes de instalar ou usar qualquer produto do Sistema de vendas, recomendamos que você verifique se seu computador atende ou excede os requisitos mínimos do sistema para o produto. Obtenha mais detalhes sobre quais versões do SV são suportadas.

###Requisitos do sistema Windows

**- Computador e processador:** Processador Intel® Core 2 ou AMD Athlon® 64; processador de 2 GHz ou mais rápido;

**- Memória (RAM):** 2 GB de RAM (recomenda-se 8 GB);

**- Disco rígido:** 2 GB de espaço disponível em disco para instalação de 32 bits; 2.1 GB de espaço disponível em disco para instalação de 64 bits; requer espaço livre adicional durante a instalação (não é possível instalar em dispositivos de armazenamento removíveis flash);

**- Monitor:** Monitor 1024 x 768 (recomenda-se 1280 x 800) com cores de 16 bits e 512 MB de VRAM (recomenda-se 1 GB)*;

**- Vídeo:** Sistema com capacidade para OpenGL 2.0;

**- Conectividade:** Requer conexão com a Internet e registro para ativação do software, validação de assinaturas e acesso aos serviços online;

**- Sistema operacional**
Microsoft Windows 7 com Service Pack 1, Windows 8.1 ou Windows 10.

###Requisitos do sistema MacOS

**- Computador e processador:** Processador Intel Multicore com suporte a 64 bits;

**- Memória (RAM):** 2 GB de RAM (recomenda-se 8 GB);

**- Disco rígido:** 2 GB de espaço disponível em disco; espaço livre adicional necessário durante a instalação (não é possível instalar em um volume que use um sistema de arquivos que faça distinção entre maiúsculas e minúsculas ou em dispositivos de armazenamento flash removíveis);

**- Monitor:** Resolução de 1024 x 768;

**- Sistema operacional**
Mac OS X Server v10.7, v10.8, v10.9 ou v10.10.

**- Conectividade**
Requer conexão com a Internet e registro para a ativação obrigatória do software, a validação da associação e o acesso aos serviços online.


###AVISO AOS USUÁRIOS
Para ativar e usar este produto, serão necessárias uma conexão com a Internet, uma DOT ID e a aceitação do contrato de licença. Este produto pode permitir a integração ou o acesso a alguns serviços online hospedados pela DOT ou por terceiros. Os serviços da DOT estão disponíveis apenas para usuários maiores de 13 anos e requer aceitação aos termos de uso e à política de privacidade da DOT. Esse aplicativo não está disponível em todos os países ou idiomas e estão sujeitos a modificações e suspensões sem prévio aviso. Taxas adicionais ou cobranças de associação podem ser aplicáveis.


**Versão do JAVA:** Versão 8

**Requisitos e considerações adicionais:** Algumas funcionalidades podem variar, com base na configuração do sistema. Alguns recursos podem exigir conectividade de hardware ou de servidor adicional ou avançada.


**Observação**
Os requisitos do sistema são arredondados para o 0,5 GB mais próximo, para ser conservador. Por exemplo, se medirmos o espaço em disco rígido exigido por um aplicativo como 1,99 GB, recomendamos 2,5 GB de espaço em disco. Nossos requisitos de sistema de disco rígido são intencionalmente maiores do que o uso real de espaço em disco do software.


# Padrões de Projeto

    **Singleton:** permite que se tenha apenas uma instância de cada aba na aplicação.

    **Decorator:** utilizado para criar a moldura das telas de cadastro e relatórios.
    Podendo posteriormente ser implantando novas funcionalidades, sem ter que seja
    adicionado em cada janela.

