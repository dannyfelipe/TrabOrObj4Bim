# Tecnologia em Análise e Desenvolvimento de Sistemas

2º Ano, 4º Bimestre - 2015 | 
[Univel](http://www.univel.br)

# Sistema
* O sistema de vendas, é um sistema genérico, podendo ser utilizado para qualquer finalidade de uma micro-empresa.

# Configuração necessária
* Para a utilização do software o usuário deverá possuir em sua esteação de trabalho alguns requisitos mínimos.

Requisitos do sistema

**- Computador e processador:** Processador x86 ou x64 bits de 1 gigahertz (GHz) ou mais rápido com conjunto de instruções SSE2;

**- Memória (RAM):** 1 gigabyte (GB) RAM (32 bits); 2 gigabytes (GB) RAM (64 bits);

**- Disco rígido:** 3.0 gigabytes (GB) disponíveis;

**- Monitor:** A aceleração de hardware gráfico exige uma placa gráfica DirectX10 e um monitor de resolução 1024 x 576 ou superior;

**- Sistema operacional**
O sistema de vendas é executado em versões de 32 bits e de 64 bits dos sistemas operacionais do Microsoft Windows. Quando você executa o SV de 32 bits em uma versão de 64 bits de um sistema operacional Windows, o programa é executado na camada de 32 bits do Windows. Para saber mais, consulte Versões de 64 bits do SV. Estes são os sistemas operacionais Windows suportados nos quais é possível executar programas de 32 bits e 64 bits do Office 2013.

O software de 32 bits do SV têm suporte nos seguintes sistemas operacionais do Windows:

    Windows 7 (32 bits ou 64 bits)

    Windows 8 (32 bits ou 64 bits)

    Windows 8.1 (32 bits ou 64 bits)

    Windows Server 2008 R2 (64 bits)*

    Windows Server 2012 (64 bits)**

O software de 64 bits do SV é suportado apenas nos seguintes sistemas operacionais do Windows:

    Windows 7 (64 bits)

    Windows 8 (64 bits)

    Windows 8.1 (64 bits)

    Windows Server 2008 R2 (64 bits)*

    Windows Server 2012 (64 bits)**

**Versão do JAVA:** Versão 8

**Requisitos e considerações adicionais:** Algumas funcionalidades podem variar, com base na configuração do sistema. Alguns recursos podem exigir conectividade de hardware ou de servidor adicional ou avançada.


**Observação**
Os requisitos do sistema são arredondados para o 0,5 GB mais próximo, para ser conservador. Por exemplo, se medirmos o espaço em disco rígido exigido por um aplicativo como 1,99 GB, recomendamos 2,5 GB de espaço em disco. Nossos requisitos de sistema de disco rígido são intencionalmente maiores do que o uso real de espaço em disco do software.

# Padrões de Projeto


    **Singleton:** permite que se tenha apenas uma instância de cada aba na aplicação.

    **Decorator:** utilizado para criar a moldura das telas de cadastro e relatórios.
    Podendo posteriormente ser implantando novas funcionalidades, sem ter que seja
    adicionado em cada janela.

