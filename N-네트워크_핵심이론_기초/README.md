# 💡네트워크 핵심 이론 기초

1. 시작
    상식
    8bit -> 1byte, 1024 = 2^10, KB -> MB -> GB -> TB … (1024MB = 1GB)
    Bit 단위 논리연산
        1011
        0010
        AND 연산으로 0010 (1은 true 0은 false, 둘다 true 일 경우 true 반환)
        마스트연산도 알아야한다.
    0010 == 4 bit == 2^4 == 16, 그래서 16진수 표기
    Process와 Program 차이
        Doc 파일이 있을 때, 보기위해 Word 또는 MS 프로그램을 설치하여 실행한다.
        프로세스는 id, 즉 pid를 가지고 있다.
    OSI 7 layer
    범용 운영체제는 User mode와 Kernel mode가 존재한다.
        컴퓨터는 하드웨워와 소프트웨어로 이루어져있다.
        소프트웨어는 시스템소프트웨어(OS) 와 그 위에서 작동하는 어플리케이션으로 나뉜다.
            그래서 어플리케이션은 User, 시스템은 Kernel 그리고 하드웨어로 나뉘어져있다.
    Buffer
        버퍼링은 버퍼를 채우는 것.
        정보가 유입되면 버퍼라는 공간에 데이터가 차올라서 화면에서 재생이 된다.
        이때, 이 메모리 공간이 버퍼다, 지하철에서 유튜브 등 동글뱅이 뜨면서 멈추는 것.
    개념(Abstraction)과 구현(Implementation)의 차이
Layer와 Layered 구조
    도식화를 하는 이유는 구성 요소간의 관계를 나타내기위해 요소를 나열하여 계층적 구조
    상위 계층은 하위 계층에 의존적이다.(의존은 행위나 기능에 적용되는 개념)
    존립(상위 계층이 존재 하려면 하위 계층이 있어야한다. 다른말로 상위계층이 있으면 하위계층이 있다.)이 의존관계이다. 일렬로. ( 4계층 | 3계층 | 2계층 | 1계층 )
네트워크와 네트워킹 그리고 개념
    네트워크를 관계라 정의할 수 있다. 네트워킹은 상호작용이라 정의할 수 있다.
            내가 너와 상호작용을 하기위해 언어가 통해야한다.
            말로 할 수도 있고 편지로도 할 수 있다.
            물속이 아니고 가까이 있어야한다.
        위 예시처럼 계층별로 이루어져야 할 것이 있다.
        언어가 통해야 말을 하든 편지를 할 수 있고, 물속이 아닌 대지 위에 있어야 말이든 편지를 할 수 있다.
            의존관계가 성립한다.
    계층별로 규칙을 정하는데, 이것을 Protocol 이라 부른다.
    개념과 구현(혹은 실체)
        연예인(개념)과 박은빈(구현)의 관계
        OSI 7 계층은 개념이다. 어려운 추상적인 부분.
        TCP/IP 문법 규칙을 공부하는 것이 좋다. 이것을 공부하고 OSI 를 공부.
User mode와 Kernel mode
    컴퓨터는 하드웨워와 소프트웨어로 이루어져있다.
    소프트웨어는 시스템소프트웨어(OS) 와 그 위에서 작동하는 어플리케이션으로 나뉜다.
        그래서 어플리케이션은 User, 시스템은 Kernel 그리고 하드웨어로 나뉘어져있다.
    NIC(Network Interface Card) : 관심갖고 봐야할 하드웨어, LAN 카드
    드라이버 : 하드웨어를 제어하기 위한 소프트웨어
    커널(OS)의 구성요소 :  프로토콜이 구현된 소프트웨어(ex. TCP IP)
    유저모드 : 커널의 구성요소를 유저모드 어플리케이션 프로세스가 접근할 수 있도록 길을 열어주는 것.
        user interface 형태가 파일 형태로 되어있다.
        TCP IP 를 추상화시킨 인터페이스 파일을 Socket 이라 부른다.
    OSI 7 계층과 연관
        User mode    - 소켓 : L7 ~ L5 (소켓을 열었다, 파일을 열었다, 주체는 Process)
        Kernel mode - TCP : L4
                      IP : L3
                      Driver : L2 (소프트웨어와 하드웨어 둘다 살짝 걸치는 수준)
        H/W			  NIC : L1
2. Internet 기반 네트워크 입문
        Layer 														식별자
        HTTP
        6계층 안다룸
        SSL(TLS)							Chrome
————————————————————————————————————
TCP, UDP							S/W		TCP				Port 번호 (업무에 따라 의미하는 식별자가 다르다.
L2에서는 인터페이스, L3는 네트워크 서비스, 소프트웨어 개발자는 Process 식별자)
Internet										IP				IP 주소(v4, v6) (호스트 식별자)
————————————————————————————————————
DataLink - Ethernet (유선인터넷)			H/W		NIC, Driver		MAC 주소	(Lan 카드 식별자)
1계층은 안다룸

    Host( Computer + Network : 네트워크 연결된 컴퓨터)
        스위치(switch) : 네트워크, 그 자체를 이루는 Host(IP 주소가 붙는 뭔가는 전부 호스트) (네트워크 그 자체란 Infra Structure),
            Router(대표적인 예), IPS(보안 스위치, 시큐리티 스위치), Tab, Aggregation(관리 목적 스위치)
        End-point : 네트워크 이용 주체, 네트워크라는 인프라 스트럭처를 써먹는 것
            단말기, Client, Server, Peer(P2P, 서비스 소비자이자 제공자를 부름)로 해당
    Switch가 하는 일
        교차로(Switch)에서 출발지를 시작으로 목적지까지 가기위해 경로(Switching)를 선택해야한다.
        그 선택에는 근거(Interface를 선택), 이정표가 있다.
            만약 근거가 IP(3계층) 주소라면 Switch는 L3 스위치가 된다.
            내가 가는 중이라하면 나는 단위로 표현되고 Packet이라 부른다.
            중간 중간 스위치를 만나면 인터넷에서는 Router라고 부른다. 즉 L3 스위치의 일종이다.
            라우터마다 이정표가 있는데, 그것을 Routing Table이라 부른다.
                Table은 표이며 그래서 자료구조 데이터가 있으며 목적지 주소와 어디로 가는 지에 대한 정보다 있다.
        MAC주소로 스위칭한다면 L2 스위치, Port 번호로 스위칭한다면 L4 스위치, HTTP 정보로 스위치하면 L7 스위치이다.

        더불어 알아야 할 것은 비용이다.
            가는 길에 대해 비용이 발생한다.
                두 갈래길을 통해 모두 목적지로 갈 수 있지만 A길은 100원 B길은 50원이 발생한다면 50원으로 가야한다.
                이러한 값을 Matric이라 한다.
3. L2
    NIC, L2 Frame, LAN 카드 그리고 MAC 주소
        NIC(Network Interface Card) == LAN(Local Area Network)
            LAN 보다는 NIC 이라는 용어를 사용하자. 
            카드라고 부르는 이유는 H/W에 직접 부착시키는 형태가 있기 때문이다.
        Host == Computer + Network (PC(Computer) 에는 여러 Interface(Network) 가 연결될 수 있다. 2개 인터페이스라면 NI * 2개)
        LAN은 네트워크의 규모 중 가장 작은 단위. WAN > MAN > LAN 으로 포함관계 형성이 되어있다.
            공유기에 여러 기기들이 연결되어 있는데, 공유기와 여러 기기들은 홈 네트워크로 구성되어 있는데 이 자체를 하나의 LAN 이라고 생각하면 된다.
        NIC 은 H/W이며 MAC 주소를 갖는다.
            하드웨어 주소(피지컬 어드레스, MAC 주소)는 H/W NIC 에 부여가 된다.
        LAN 카드는 여러 형태로 컴퓨터와 연결이 가능하다.
            H/W 에 직접 연결, USB 로 연결, 무선 연결
    L2 스위치에 대해서
        L2 Access switch
            - End-point와 직접 연결되는 스위치
            - MAC주소를 근거로 스위칭
            - DOD(TCP/IP 4계층)의 1계층 Network Access
            - L2 스위치이기에 MAC 주소를 가지고 스위칭
            - 각 Port를 Interface라고 부른다.(LAN 선을 꽂는 부분, 이 허브를 통해 PC와 연결) / 24개가 있으면 24Port Hub 라고 부른다.
            L2 스위치 연결 시
                - Interface에 LED가 있는데, 주황색이면 충돌이 났다는 표시이다.
                - 연결이 잘 되면 녹색불이 들어온다. 이것을 Link-up 됬다고 한다.
                - 연결이 끊어지면 Link-down 이다.(물리적으로 케이블은 분리했다는 뜻)
                - LAN 케이블을 꽂아서 상위(L3, 라우터)로 나아가는 것이라면 Up-Link
        L2 Distribution switch(아래 고성능 스위치를 의미)
            PC		-		L2 switch		-		switch		-		Router
            (Endpoint)							(고성능 스위치, 하위로 L2, PC 가 있을 수 있음, 한마디로 여러 L2 스위치를 연결할 수 있다 이것으로 여러 PC 가 통신이 가능)
        예시	사무실			방						층					건물
            - 쉽게 생각하면 L2 Access 스위치를 위한 스위치
            - VLAN(Virtual LAN) 기능을 제공하는 것이 일반적
            - 스위치를 위한 스위치
    LAN과 WAN의 경계 그리고 Broadcast(주소, 방송 주소, 효율이 떨어진다, 꼭 필요한 곳에서 최소한의 단위로 사용)
        - Broadcast 의 반대는 Unicast
        - Broadcast 범위 : 최소단위로 해야한다.
        - Broadcast 주소라는 매우 특별한 주소가 존재(MAC, IP 모두 존재)
            MAC - 맥 어드레스가 48bit 로 표현 된다면 Broadcast 이다.
        - PC가 Broadcasting 이 한번 되면 L2 switch 에 연결된 다른 PC 나머지는 통신이 안된다. Broadcasting 이 끝날 때까지.
        - distribution switch 가 Broadcasting 하는 한 L2 switch 를 묶으면 다른 L2 switch 에 있는 PC는 통신이 가능하다.
        요령
            S/W Logical		Internet(IP) 	-> IPv4 주소	|	논리적 네트워크, 실체가 없다.(마우스 포인터가 될 수도 있다.)
                다른 말로 Virtual 로도 사용, 실체가 없는 것으로 가상이라는 말을 많이 사용한다.
            H/W Physical		Ethernet 		-> MAC 주소	|	물리적 네트워크
            H/W 를 S/W 로 구현이 가능하다
                예로 CPU -> Machine 이 있다. (그래서 Virtual Machine 이라 부른다.)
        네트워크의 가장 작은 단위는 LAN, H/W인 Physical 이 LAN 으로 볼 수 있다. S/W 는 WAN 으로 볼 수 있다.
4. L3
IPv4 주소의 기본 구조
    L2 에서 MAC 주소는 식별자, 48bit
    L3 에서 IP 는 식별자, 32bit = 8bit *4;
        2^8 = 256,  255 = 1111 1111, 
        1111 1111 이러한 형태는 broadcast 를 떠올릴 것.
        192.			168.			0.			10				
        1100 0000 	1010 1000	0000 0000	0000 1010
        ——————— Network ID —————-——       Host ID
        -> IP(Internet Protocol) 를 사용하는 인터넷 망에서 인터넷을 사용하는 컴퓨터를 식별하기 위한 host 는 위와같이 생겼다.
        Network ID 로 서울시 강남구 역삼동까지 찾고 Host ID 로 255번지에 도착하게 된다.
L3 IP Packet으로 외워라
    - 페킷은 단위 데이터이다.
    - Packet 이라는 말은 L3 IP Packet 으로 외워라.
    - Header 와 Payload 로 나뉘며 이는 상대적인 분류이다. (L2 에서도 Frame 으로 헤더와 페이로드로 분류된다.)
        - 헤더가 실어 나르는 대상이 페이로드이다.
    - 최대 크기는 MTU (1500 byte = 1.4 kb)
    - 패킷의 실체를 Wireshark 로 볼 수 있다.
    주소 안에는 Src 소스 -> Dst 데스티네이션 가 있다.
Encapsulation과 Decapsulation
    - 택배를 보내기 위해 상품을  박스에 담고 테이핑을 한다. 포장 (Encapsulation, 단위화)
        러시아 목각인형 처럼
    - En/Decapsulation
        Header(L2)				Payload #1
                                Header(L3 IP Packet)		Payload #2
                                                        Header(L4 Tcp Segment -> Stream) Payload #3
        payload #1 안에 L3, payload #2 안에 L4 가 있다.
패킷의 생성과 전달
    User mode 에서 Process 가 인터넷을 통해 Data 를 전달하려 한다.
    Interface(socket) 을 통해 Kernel mode 에 전달하기 위해
    Data 를 socket 에 write 한다. 표현은 TCP 로 넘어가는 TCP socket 이기 때문에 write 가 아닌 send 이다.
        (socket 은 file 이다. Kernel mode protocol 을 추상화한, user mode application process 가 접근할 수 있도록 추상화한 Interface)
    L4 에서 Data 옆에 TCP 를 붙여 Segment화를 한다. ( Segment 라 부른다 > | TCP | Data | )
    L3 에서는 L4 와 동일하게 전달받은 Segment 에 IP를 붙인다.  | IP | TCP | Data |
    L2 에서는 Ethernet Frame 이 붙는다. | Frame | IP | TCP | Data |
    그리고 NIC를 통해 L2 Access 를 통하고 라우터를 통해 네트워킹을 한다.
계층별 데이터 단위
    Chrome
    Socket		Stream (일반적으로 스트리밍 서버스와 같은 말, 시작은 있지만 끝은 Application 수준에서 정해진다. 스트림을 소켓에 Write 를 한다. 4MB)
                        스트림은 단위라기 보다 데이터 덩어리가 맞다.
    TCP			L4 : Segment		[MSS] Maximum segment size 스트림의 용량보다 최대용량이 작기 때문에 스트림이 더 크다면 분할해서 전달한다.
    IP			L3 : Packet		[MTU] Maximum transmission unit
    Driver		
    NIC			L1 ~ L2 : Frame
    (UDP 에서는 Datagram 이라 부르며 Packet 과 성질이 비슷하다.)
[중요] 이해하면 인생이 바뀌는 TCP/IP 송.수신 구조
    에펠탑을 택배로 보내는 방법
        1. 에펠탑 -> 분해 -> 크기 -> 박스(MTU) 포장
        2. 운송
        3. 조립
        분해는 송신측, 조립은 수신측에서 한다.
        박스 하나가 Packet이 된다. 인터넷에서 패킷이라는 단위로 데이터가 유통된다.
        전체적 흐름을 보자, 흐름이란 TCP/IP 를 지칭한다.
    PC -> Internet -> Server
        PC Process가 파일을 수신
        Server Process가 파일을 송신
        Packet 단위로 파일을 송수신, MTU : 1.4 x KB | File : 1.4 MB  /  1024배 차이 즉, 패킷을 1000개 이상 분해하여 보낸다는 개념이 된다.
    서버 측
        데이터를 송신하기 위해서 퍼즐 100개가 맞춰져있는 파일 하나를 전송한다고 하면,
        Server(파일을 Send하는 일을 한다.)
            파일을 이루는 퍼즐 10개를 Copy 해서 버퍼에 담는다.
            그리고 소켓에 Send 한다.(보낼 때 10개의 퍼즐을 붙여서 하나로 보낸다.)
        Socket
            receive 한 퍼즐 10개를 다시 버퍼에 담는다.
            (서버의 버퍼에 담은 데이터, 소켓의 버퍼에 담은 데이터 단위를 Stream 이라고 한다.)
            그리고 I/O 를 진행하는데, TCP(L4)로 보낼 때, 10개의 퍼즐이 하나로 된 상태에서 다시 10개로 분해하고 번호를 붙인다.
            그 다음 첫번째 번호의 데이터를 전송한다.
        TCP(L4)
            전송 받은 하나의 데이터를 Segment라고 부른다.
            그렇게 L3(IP)로 세그먼트를 전송을 한다.
        IP(L3)
            L4의 세그먼트를 박스에 담아 Packing 하면 이 데이터는 Packet이 된다.
            이 패킷에는 하나의 세그먼트를 담고 있고, 송장이 붙어서 L2로 보내진다.
        L2
            패킷을 트럭에 담는데, 이것을 Frame 이라 부른다.
            그리고 이 프레임을 클라이언트 측으로 전달한다.
            중요하게 알고 갈 것은 프레임은 유통과정에서 계속해서 바뀐다.
            (마치 미국에서 한국으로 택배를 보낼 때, 미국에서 공항까지 가는 프레임, 미 공항에서 한국공항가는 비행기로 가는 프레임, 한국에서 목적지까지 가는 프레임 이렇듯이..)
    클라이언트 측
        L2
            서버에서 보낸 프레임과 다른 프레임이 도착한다.
            그 프레임에서 패킷을 꺼내면 프레임은 사라진다.
            또한 패킷에서 세그먼트를 꺼내고 박스는 버리게 된다.		
    서버에서는 Encapsulation 이 일어나고, 클라이언트에서는 Decapsulation 이 일어난다.
        Socket
            TCP 에서 전달 받은 세그먼트를 버퍼에 다시 채워나간다.
        Chrome
            소켓 버퍼에 쌓인 데이터를 크롬의 버퍼에 채워(Read)나간다. (이것을 Receive 라고 한다.)
    네트워크에서는 소켓 버퍼를 채우고 프로세스는 비우고 있다. (소켓 버퍼의 데이터를 프로세스 버퍼에 채우는 과정)
    그렇게 서버의 프레임은 패킷을 나르게되는데, 세그먼트 1,2,3.. 을 보내게 되면 Socket 의 버퍼는 세그먼트를 채우는 과정이 되고
        세그먼트 2를 채운다면 TCP는 잘 받았다는 피드백을 하게 된다.
    TCP 에서 피드백을 하면, ACK #3 을 보내는데 이 뜻은 세그먼트 2까지 왔다는 뜻이다.
        (소켓의 버퍼는 세그먼트 2까지 왔기 때문에 여유 공간이 줄어든다.
    서버에서는 ACK #3 을 기다린다. 그리고 클라이언트에서 ACK #3 을 보내면 서버에서 세그먼트 3을 보낸다.(이렇게 계속 반복된다.)
        프로세스 버퍼에서 데이터를 받고 소켓의 버퍼를 비우면 여유공간이 다시 늘어나는데, ACK #3 에 여유 공간이 있는지 까지 보낸다.(여유 공간이 있으면 보내고 없으면 안보냄)
    네트워크 장애
        1) Loss (유실)(네트워크 문제) : 데이터 유실
        2) Re-trans- 또는 ACK-Dup (재전송)(네트워크 또는 엔드포인트 문제) : 서버쪽에서 ACK #3 을 기다리는데, 오지않으면 세그먼트 1,2 를 다시 보낸다.
                            이때, 클라이언트도 프로세스가 진행되어 ACK #3 을 보내는 도중에 세그먼트 1,2가 오면 ACK-Dup 중복이 된다.
        3) Out of order(네트워크 문제) : 세그먼트 1 -> 2 -> ? -> 4, 또는 1 -> 2 -> 4 -> 3… 이렇게 순서가 안맞거나 제대로 오지않을 경우. 그러면 운영체제 수준에서 보정을 하게 된다.
        4) Zero window(엔드포인트의 어플리케이션에서 문제) : 수신측 소켓 버퍼의 여유공간의 크기를 Window Size라고 부른다.
                        프로세스가 어떤 이유로 비우지 않고 소켓 버퍼가 다 채워져있을 때, 수신을 할 수 없다.
IP 헤더 방식
    IPv4 Header 형식
        |->										    ->| MTU : 1500 byte, 32bit	8 bit -> 1 byte, 4bit + 4bit -> 2^4 + 2^4-> 2^4 = 16 진수 wireshark
        |	Header(IP)		|		Payload			|
            20 byte					1480 byte
                
        Version	IHL		TOS		Total length
        0		4		8		16				31 bit

        IHL : Internet Header Length, Header 의 길이를 말하고 보통 5 정도이고 4byte 이기에 20 byte

        이건 다시 봐야할듯

서브넷 마스크와 CIDR
    Subnet Mask
        ifconfig 로 설정정보 확인
        192.168.0.  	10
        Net ID        	Host ID
        1100 0000. 1010 1000. 0000 0000. 0000 1010		2진수
        1111 1111.     1111 1111.    1111 1111.      0000 0000
        1100 0000. 1010 1000. 0000 0000. 0000 0000	bit 단위로 AND 연산, 이렇게 AND 연산해서 Host 쪽은 0으로 잘라내는 것을 Mask 연산이라 한다.
        Mask 연산을 수행해서 Network ID 가 같다면 이 패킷은 우리 네트웤으로 오는 패킷이라고 판단한다.
    CIDR(Classless Inter-Domain Routing, 싸이더) - 예전에는 8비트 단위로 끊어서 A class 16비트면 B class, 24 C class, 32 D class 로 불렀다.
        싸이더 표기 방법
        192.168.0.10/24		Net ID 로만 24 bit
        255.255.255.0		
        FF.   FF.   FF.  24		이렇게 표기하는 것보다 위에 표기법이 더 좋아서 위 두 표기법을 사용
Broadcast IP 주소
    MAC 주소 : 48 bit, FF-FF-FF ——
    Host ID 를 255 로 쓰면 Net ID 의 네트워크에서 방송 주소로 쓰인다.
        Host ID 가 255 이 아닌 일반적으로는 목적지 한 곳으로만 가게 되는데,
        255 를 사용하면 라우팅에 연결된 모든 PC 및 게이트웨이를 통해 인터넷으로 가는 곳까지 전부 보내게 된다.
        즉 255, 브로드 케스팅은 전체에 보내는 것을 말한다.
        자주 사용하면 효율이 떨어진다. 네트워크 장비에 부담이 늘게된다.
    네트워크에서 쓸수 없는 IP 주소
        Host ID 가 0이면 서브넷 마스크 결과와 일치하기 때문에 사용 못한다.
                  255 면 브로드 케스트이기 때문에 사용 못한다.
        그래서 256 개에서 2개를 제외한 254 개를 사용할 수 있다.
        게이트웨이를 보통 1번을 주기 때문에 순수 PC 에 사용하는 것은 250개 정도 된다.	
Host 자신을 가리키는 IP 주소
    127.0.0.1
        일반적으로 PC - Route - Internet - Route - Server 로 얘기한 198.162.0.10 이었지만
        내가 나에게 접근할 때의 주소가 127.0.0.1 이다.
        인터넷에 연결된 컴퓨터인 Host 가 내가 나에게 접근할 때.
        접속, 연결하는 주체가 Process이다.
        이것을 Loop back Address 라 부른다. (나 자신을 가리킨다.)
    프로세스간 통신을 할 때, 유저모드에서 커널모드의 L3 만 거쳐서 다시 응답 프로세스까지 도달하게 된다.
        L3 IP 를 통해 주소를 알아올 수 있지만 변경될 수도 있기에 127.0.0.1 로 정해버리는 개념이다.
TTL과 단편화
    인터넷은 라우터의 집합체라고 할 수 있는 논리 네트워크이다.
        라우터와 L3 Switch 와 비교
            라우터를 L3 스위치에 포함된다 상관없다 반대다 라는 논란이 있다.
            선생님 개인적으로는 상관없고 궂이 따지면 포함된다고 생각한다.
        인터넷의 핵심은 라우터와 DNS(라우터만 다룬다.)

    패킷이 목적지까지 가는데 실패하는 경우
        패킷을 제거하고 다시 보내야하는데 살아 있다면 문제가 되는데 이런걸 정리하는게 TTL이다.

    - Time To Live 는 세포의 ‘텔로미어’ 같은 역할을 한다.
    - 단편화는 MTU 크기 차이로 발생한다.
    - 보통 단편의 조립은 수신측 Host 에서 이루어진다.
    
        MTU 크기는 보통 1500 byte, 보내는게 1500 받는게 1400 이면 잘라서 보내게 되는데 이렇게 자르는 것을 단편화라고 한다.  (라우터에서 라우터로 넘어가는걸 Hop 이라한다. 깡총)
        Client PC 와 Server 는 1500, 라우터에서 라우터를 거쳐 중간 라우터가 1400 이면 해당 라우터에서 패킷을 두개로 만들어 자르는데,
            | IP | A payload |
            | IP | B payload |	이렇게 패킷을 단편화 해서 보내고 서버에서 조립한다.
        가급적이면 일어나지 않는 것이 좋기 때문에 아예 처음부터 즉, PC 에서 1400으로 보내는 것이 좋다.
        요즘은 전부 1500이기 때문에 보통 VPN 때문에, IPSec 이 적용될 때 일어나는 경우다.

인터넷 설정 자동화를 위한 DHCP
    인터넷 사용 전에 해야 할 설정
        - IP 주소 : IPv4 32bit
        - Subnet mask
        - Gateway(집에서는 공유기) IP 주소
        - DNS 주소
        IP주소, 서브넷 마스크, 게이트웨이 주소 모두 L3 에서 작업
    DHCP(Dynamic Host Configuration Protocol)
        - DHCP 체계는 주소를 할당하는 서버와 할당 받으려는 클라이언트로 구성된다.
        - 복잡한 인터넷 설정을 자동으로 해준다고 볼 수 있는데, 핵심은 내가 사용할 IP 주소를 서버가 알려준다는 것에 있다.
            IP주소, 서브넷 마스크, 게이트웨이 주소, DNS 모두 자동으로 할당
            Dynamic 은 IT 에서 Runtime, 동적인, 컴퓨터가 작동중인 이라는 뜻으로 사용
            PC 가 켜지면 브로드케스트 패킷이 나간다. 그러면서 DHCP Server 가 있는지 확인한다.
                서버가 응답하면 PC 가 기존에 사용하던 주소를 사용할지 서버에 확인한다.(처음이라면 확인하지않고 바로 주소를 할당받는다.)
                IP주소, 서브넷 마스크, 게이트웨이 주소 등 인터넷 사용에 필요한 모든 정보를 응답한다.
                    서버는 Address Pool 에 IP를 가지고 있다가 보내준다.
ARP(Address Resolution Protocol) - Address : IPv4 주소 + MAC 주소	/	Host 에서 보통 주소는 두가지, L3 IPv4 주소와 L2 NIC(NetworkInterfaceCard) MAC 주소
    - ARP는 IP주소로 MAC주소를 알아내려 할 때 활용된다.
    - 보통의 경우 PC 를 부팅하면 Gateway 의 MAC 주소를 찾아내기 위해 ARP Request 가 발생하며 이에 대응하는 Reply 로 MAC 주소를 알 수 있다.
        반드시 Gateway 의 MAC 주소를 알아야 인터넷을 할 수 있다.
        PC 는 네이버와 통신을 할 때, 목적지 MAC Address는 Gateway 로 잡힌다.
        GW 는 그때 IP 패킷 헤더를 보고 목적지를 확인하고 판단해서 움직인다.
Ping과 RTT
    - Ping 유틸리티(그냥 프로그램, 프로토콜이 아니다)는 특정 Host 에 대한 RTT(Round Trip Time) 을 측정할 목적으로 사용된다.
    - ICMP 프로토콜을 이용한다.
    - DoS(Denial of Service) 공격용으로 악용되기도 한다.
    핑이란 회선의 연결 상태, 그냥 프로그램 이름이다. ICMP 를 이용해서 RTT 를 측정하는 것.
        게임할 때, 여러명이 같이 사용하는데 한사람의 RTT 가 혼자 오래걸리면 문제
    인터넷이 다른건 되는데 한 서버에 접근이 안되면 cmd 에 ping 을 날려보낸다. 응답이 없으면 문제
    RTT 는 거리가 아니라 속도의 차이이다. 회선의 차이가 될 수 있고 동일한 조건으로는 거리로 속도가 차이날 수 있다.
5. L4
    TCP와 UDP 개요
        - TCP 에만 연결(Connection, Session) 개념이 있다.
            TCP Connection 연결이라는 것이 굉장히 논리적(Virtual)이다. - Virtual Circuit
        - 연결은 결과적으로 순서번호로 구현된다.
            순서번호는 4계층에서 세그먼트의 번호를 이야기 한다.
        - 연결은 ‘상태(전이)’ 개념을 동반한다.
            전화 -> 통화가 되기 전 연결, 연결 후 통화, 통화 종료 후
        - TCP 는 배려남, UDP 는 나쁜 남자에 비유할 수 있다.
            TCP Segment 수신할 때 여유공간이 없을 때, Zero Window 문제를 확인하는것에서 데이터를 보낼지 결정을 할 수 있는데
            UDP 는 확인 없이 보낸다.

        Socket								Stream(시작은 있는데 끝은 계측하기 어려움, 소켓통신이라는 프로세스가 정하는 것.어플리케이션 프로토콜 규정에 따른다.)
        TCP, UDP		->		Port 번호		Segment(TCP), Datagram(UDP)
        IP				->		IPv4 주소		Packet
        Ethernet			->		MAC 주소		Frame

        TCP
            Client / Server 로 구성
            클라이언트 프로세스는 소켓을 Open 한다.(소켓을 생성해서 오픈)
                프로세스가 자신의 식별자인 PID 갖는데, PID 를 가진 클라이언트 프로세스가 운영체제 입장에서 소켓이다가 TCP Port 번호를 부여한다.
            서버 프로세스는 연결 대기
                프로세스가 소켓을 생성하고 개방한다.(LISTEN)
                이때, 프로그램이 OS 한테 포트번호를 받아야한다고 얘기한다.
                사용가능하다면 소켓이 열리고 그때부터 연결대기 상태가되고 통신이 된다.
            
            이렇게 통신을 하기 위해서 IP와 접속 가능한 TCP 나 Port 를 알아야 연결 시도가 가능하다.
            서버가 연결대기 상태가 아니고 프로세스도 없고 소켓이 열리지 않은 상태에서 클라이언트가 연결 시도를 하면 운영체제 수준에서 자동으로 연결을 못받아준다는 응답이 간다.
        UDP	
            연결이라는 개념은 없지만 구조는 비슷하다.
            클라이언트에서 포트번호 부여하는 것도 동일하다.
    TCP 연결과정
        TCP 연결 과정(3-way handshaking)
            연결이 결론이라면 연결의 과정으로 등장하는 것이 3-way handshaking 이다.
        세로 선 - Time line
        SYN ACK 등 이것이 Segment 인데 앞서 배운 개념과 좀 다르다.
            Header 와 Payload 가 있었는데 Payload 가 없다. IP 와 TCP 만 있다. 단순 연결 목적, 관리 목적의 세그먼트가 왔다갔다 한다.
            클라이언트에서는 시퀀스 넘버를 생성하고 연결 시도 한다.
                요청을 보낼 때, SYN 에 시퀀스넘버를 담아 알려준다.
            서버에서 연결대기 중인 프로세스가 응답을 보낸다.
                응답을 보낼 때, 클라이언트가 보낸 시퀀스 넘버에 +1을 하고 서버의 시퀀스 넘버로 같이 보낸다.
            클라이언트는 서버에서 받은 시퀀스번호에 +1를 해서 다시 세그먼트를 보낸다.
            
        클라이언트는 서버에서 첫 번째로 응답했을 때, (서버의 시퀀스를 받았을 때) 연결 됐다고 생각한다.
            하지만 그 시기에 서버는 연결이 완료됐다고 생각하지 않는다.
            라운드 트립타임(RTT)에서 한방향쪽으로 가는 대략 25ms 가 지나면 클라이언트에서 마지막 ACK 를 보내서 서버가 받으면 그때 연결 됐다고 생각한다. 정확히는 그렇다고 판단한다.

        시퀀스 번호를 교환하는 것이 연결에 가장 중요하다.
        정책 교환도 한다, MSS(Maximum Segment Size)가 얼마인지 알려준다.
            클라이언트가 서버에 접속할 때 MSS 알려주고 서버도 MSS 를 응답한다.

        - 요약
            TCP 연결은 정책교환하는 것이다.
            그 안에 시퀀스 번호와 여러가지가 있지만 MSS 가 있다.
            연결이라는 것은 이러한 관리적 정보, 프로토콜이 규정하는 정보를 교환하는 것이다.
        
        이 연결이라는 것은 피지컬한 서킷이 아니라 버츄얼 서킷이다.
            실제 선을 끌어서 연결하는 것이 아니다. 
    TCP 연결종료 및 상태변화
        TCP 연결 종료 과정(4-way handshaking)
        
        특별한 이유가 없다면 클라이언트의 행동이 Active 하다.
            연결을 하자고 하는것도 연결을 끊겠다는 것도 클라이언트이다.
        
        클라이언트는 서버를 끝자고 FIN + ACK을 보낸다. (Finish)
        서버는 요청을 받고 ACK 를 보낸다.
        클라이언트는 ACK 를 받고 FIN 을 더 기다린다.
        서버에서는 FIN + ACK 를 또 보낸다
        클라이언트는 FIN+ACK 를 받고 ACK 를 보낸다.
        
        클라이언트는 서버에서 FIN + ACK 를 받고  TIME_WAIT 가 발생한다.
            이 상태는 클라이언트에서 연결을 끊자고 하는 것이다.
            TIME_WAIT 라는 것은 연결을 끊자고 하는 주체가 일으키고, 연결이 최종 완료되기 전에 발생한다.
        
        TIME_WAIT 과 비슷하게 서버에서 처음 FIN+ACK 를 받으면 CLOSE_WAIT 이 발생하는데,
            클라이언트에서 던진 연결 끊자는 신호를 받아서 연결 종료하는 시퀀스로 가기 위함이다.
        
        클라이언트에서 TIME_WAIT 에서 CLOSE 로 넘어가는 것은, 일정 시간이 지나면 그렇게 되고 소켓이 회수가 된다.
            소켓 이라는 것은 자원이다. 그래서 무한 자원이 아니고 쓸 수 있는 개수제한이 있다.
            그래서 서버가 연결을 끊으면 소켓이 낭비가 될 수 있기에 클라이언트에 알려주고 클라이언트가 끊도록 유도한다.(소켓, 서버 개발도 이렇게 해야한다.)
         			TCP (연결) 상태 변화
            다시한번 보자
    TCP, UDP 헤더형식과 게임서버 특징
        TCP
            TCP segment header 는 32bit 이다.
                Port 번호가 나올 수 있는 경우의 수는 2^16 이며 0 ~ 65535 (2^16 -1) 인데, 0과 65535눈 사용할 수 없다
            Sequence number
            Acknowledgment number(if ACK set)
            Flag 값 (FIN, SYN…)
            Window Size (TCP buffer여유공간)
        UDP
            혼잡 제어가 없다.
            빨리 많이 보내야할 때 사용, 대표적으로 IPTV 영상 송출
            게임 서버
    TCP ‘연결’이라는 착각
        파일 다운로드 중 렌 케이블을 분리 했다가 다시 연결하면 TCP 연결은 어떻게 될까?
        heart bit 			TCP 연결이라는 착각
            - 재전송 타이머의 기본 근사 값은 대략 3초이다.	하지만 대부분의 운영체제들은 1초 미만이다.
            - 재전송 타이머 만료 후에도 확인 응답을 받지 못한 경우 세그먼트를 재전송하고 RTO(Retransmission Time-Out) 값은 두 배로 증가한다.
            - 예를 들어 1초 > 2초 > 4초 > 8초 > 16초 간격으로 재전송한다.
            - 보통 최대 5회 재전송을 시도하고 5회 이상 모두 실패할 경우 보통 전송 오류가 발생한다.
            재전송, 왔는지 확인
            랜 케이블 빼고 1초 후에 다시 끼면 받던 다운을 계속 진행
            L4 에서 논리적 연결을 지속하는데, 이런것을 충격이라고 볼 수 있다.
            버퍼를 충격 완화 장치라고도 한다. (5초 의 크기에서 1초를 보내면 4초가 남는다.)
    TCP 연결과 게임버그
        - 어떤 MMORPG 게임에서 아이템 복제 버그가 발생하였다.
        - 이는 논리적 TCP 연결과 물리적 링크간 차이를 이용한 시간차 공격이라 볼 수 있으며 연결이 사실은 End-point 의 주관적 판단에 불과하다는 것을 보여준다.
        
        연결이라는 것은 보안성이 없다. (기밀, 무결, 가용 이 없음)
        
        이런 사례가 있다는 정도.
6. 웹을 이루는 핵심기술
    DNS (도메인 네임으로 IPv4 주소를 알려주는 놈)
        분산 구조형 데이터베이스 (자료구조는 분산 구조형으로 되어있음)
            데이터베이스 시스템(DNS 네임서버)의 분산 구성
            데이터의 영역별 구분(Domain Zone) 및 분산관리
            도메인의 네임서버 및 도메인 데이터는 해당 관리주체에 의해 독립적으로 관리됨

        트리(tree) 구조의 도메인 네임(Domain Name) 체계
            Domain : 영역, 영토를 의미
            도메인 네임의 자율적 생성
            생성된 도메인 네임은 언제나 유일(Unique) 하도록 네임 체계 구성

                - www.naver.com
                www 가 작은 개념이고 naver 에 속해있고 naver 는 com 에 속해있다
                www.naver.com	:	URL, URI 통상적으로 URL 주소라고 부른다
                naver.com 		:	domain name
                www 			:	Host Name 
                결국 HostName 과 DomainName으로 나누어져 있다

            DNS 주소는 ISP 에서 정해준걸 사용, DNS 응답이 느려지면 인터넷 전체가 느려진다
            한 ISP 가 Google DNS 8.8.8.8 을 세팅
            내가 쓰는 ISP 에서 알아 보는 것이 여러 ISP 를 거쳐 IP를 알아오는 것 보다 빠르다

            DNS 에서 알아온 IP 를 URL 과 함께 PC 가 메모리에 저장해둔다. 이것을 DNS Cache 라고 한다.
            IP주소 를 응답할 때 같이 오는 것이 유효기간이다. DNS Cache 저장 기간 (주소 + 유효기간)
            결국 유효기간 안에서는 DNS 에 가지않고 캐시에서 꺼내온다
            
        전체 흐름
            PC -> 공유기 -> ISP -> DNS (이것도 정확히 말하면 DNS Cache) -> ROOT DNS (전세계 13대있음 iana.org 가면 알 수 있고, 질의도 가능) -> DNS -> ISP -> 공유기 -> PC
                                                                    (com 에 해당하는 데이터를 알아오는 것도 N 대가 있다 그리고 www 로 추적해서 알아온다.)
            
    URL 과 URI
        Uniform Resource Locator(위치)
        Uniform Resource Identifier(식별자)
            Uniform 통합, 그러면 Resource 는 무엇인가
                Web -> HTML + HTTP
            URL 은 URI 의 큰 범주 안에 있다.
            
        URI 구조
            URI = scheme “:” [“//“ authority]
            path [“?” query] [“#” fragment”]
            
            Protocol://Address:PortNumber/Path(or filename)?Parameter=value
            http://www.test.co.kr/course.do?cmd=search&search_keyword=Test
                course.do 경로 (파일경로)
                
            Web : TCP 80 Port 를 많이 사용 (생략가능) 8080 도 많음
            
    굵고 짧게 살펴보는 HTTP
        HTTP
            - HTTP 는 HTML 문서를 전송 받기 위해 만들어진 응용 프로그램 계층 통신 프로토콜이다. (L7 에 해당)
            - 1996년에 1.0 스펙이 발표되고 1999년 6월에 1.1이 발표되었다.
            - 기본적으로 클라이언트의 요청에 대응하는 응답형식으로 작동한다.
            - 헤더는 다음과 같이 분류된다.
                일반 헤더
                요청 헤더
                응답 헤더
                엔티티 헤더
            - 요청에 사용되는 메서드는 주로 GET, POST 이다.
            
            L5 이상이면 Socket 통신을 하는 것이고 + (Socket 통신은)Stream 데이터 이다.
                시작은 있는데, 끝이 언제인지 해석을 해봐야 한다. 이 해석의 규정이 HTTP 에 들어있다.
            
        응답 코드
            200 OK
            201 Create
                요청에 대한 새로운 자원 생성 성공
            301 Moved permanently
            302 Found
            400 Bad request
            403 Forbidden
                권한이 없거나 잘못된 파일 실행 접근시도
            404 Not found
                없는 리소스 찾을 때
            500 Internal server error
                내부 오류 때문에 요청을 처리할 수 없음
            
        HTTP method
            GET : Download
            POST : Upload (File - ID/Pwd) ..
            HEAD
            TRACE
            PUT
            DELETE
            OPTIONS
            CONNECT