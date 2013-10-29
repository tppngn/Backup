# jul/26/2013 14:53:00 by RouterOS 5.4
# software id = VGBI-RG59
#
/interface ethernet
set 0 arp=enabled auto-negotiation=yes bandwidth=unlimited/unlimited \
    disabled=yes full-duplex=yes l2mtu=1598 mac-address=00:0C:42:EF:8B:51 \
    master-port=none mtu=1500 name=ether1-gateway speed=100Mbps
set 1 arp=enabled auto-negotiation=yes bandwidth=unlimited/unlimited \
    disabled=no full-duplex=yes l2mtu=1598 mac-address=00:0C:42:EF:8B:52 \
    master-port=none mtu=1500 name=Salida_Internet_Port_2 speed=100Mbps
set 2 arp=enabled auto-negotiation=yes bandwidth=unlimited/unlimited \
    disabled=no full-duplex=yes l2mtu=1598 mac-address=00:0C:42:EF:8B:53 \
    master-port=none mtu=1500 name=Ingreso_morosos_Port_3 speed=100Mbps
set 3 arp=enabled auto-negotiation=yes bandwidth=unlimited/unlimited comment=\
    test disabled=yes full-duplex=yes l2mtu=1598 mac-address=\
    00:0C:42:EF:8B:54 master-port=Salida_Internet_Port_2 mtu=1500 name=\
    ether4-slave-local speed=100Mbps
set 4 arp=enabled auto-negotiation=yes bandwidth=unlimited/unlimited \
    disabled=yes full-duplex=yes l2mtu=1598 mac-address=00:0C:42:EF:8B:55 \
    master-port=Salida_Internet_Port_2 mtu=1500 name=edsdsdther5-slave-local \
    speed=100Mbps
/interface vlan
add arp=enabled disabled=no interface=Salida_Internet_Port_2 l2mtu=1594 mtu=\
    1500 name=vlan1 use-service-tag=no vlan-id=10
/interface ethernet switch
set switch1 mirror-source=none mirror-target=none name=switch1
/ip hotspot profile
set default dns-name="" hotspot-address=0.0.0.0 html-directory=hotspot \
    http-cookie-lifetime=3d http-proxy=0.0.0.0:0 login-by=cookie,http-chap \
    name=default rate-limit="" smtp-server=0.0.0.0 split-user-domain=no \
    use-radius=no
/ip hotspot user profile
set default idle-timeout=none keepalive-timeout=2m name=default shared-users=\
    1 status-autorefresh=1m transparent-proxy=no
/ip ipsec proposal
set default auth-algorithms=md5,sha1 disabled=yes enc-algorithms=\
    des,3des,aes-128,aes-256 lifetime=30m name=default pfs-group=none
add auth-algorithms="" disabled=no enc-algorithms=aes-256 lifetime=30m name=\
    proposal1 pfs-group=none
add auth-algorithms=sha1 disabled=no enc-algorithms=3des lifetime=30m name=\
    proposal2 pfs-group=none
/ip pool
add name=default-dhcp ranges=192.168.88.10-192.168.88.254
/ppp profile
set default change-tcp-mss=yes name=default only-one=default use-compression=\
    default use-encryption=default use-mpls=default use-vj-compression=\
    default
set default-encryption change-tcp-mss=yes name=default-encryption only-one=\
    default use-compression=default use-encryption=yes use-mpls=default \
    use-vj-compression=default
/queue type
set default kind=pfifo name=default pfifo-limit=50
set ethernet-default kind=pfifo name=ethernet-default pfifo-limit=50
set wireless-default kind=sfq name=wireless-default sfq-allot=1514 \
    sfq-perturb=5
set synchronous-default kind=red name=synchronous-default red-avg-packet=1000 \
    red-burst=20 red-limit=60 red-max-threshold=50 red-min-threshold=10
set hotspot-default kind=sfq name=hotspot-default sfq-allot=1514 sfq-perturb=\
    5
set default-small kind=pfifo name=default-small pfifo-limit=10
/routing bgp instance
set default as=65530 client-to-client-reflection=yes disabled=no \
    ignore-as-path-len=no name=default out-filter="" redistribute-connected=\
    no redistribute-ospf=no redistribute-other-bgp=no redistribute-rip=no \
    redistribute-static=no router-id=0.0.0.0 routing-table=""
/routing ospf instance
set default disabled=no distribute-default=never in-filter=ospf-in \
    metric-bgp=auto metric-connected=20 metric-default=1 metric-other-ospf=\
    auto metric-rip=20 metric-static=20 name=default out-filter=ospf-out \
    redistribute-bgp=no redistribute-connected=no redistribute-other-ospf=no \
    redistribute-rip=no redistribute-static=no router-id=0.0.0.0
/routing ospf area
set backbone area-id=0.0.0.0 disabled=no instance=default name=backbone type=\
    default
/snmp
set contact="" enabled=yes engine-id="" location="Alta Barda / Neuqu\E9n" \
    trap-community=tppar trap-target=0.0.0.0 trap-version=1
/snmp community
set tppar address=0.0.0.0/0 authentication-password="" \
    authentication-protocol=MD5 encryption-password="" encryption-protocol=\
    DES name=tppar read-access=yes security=none write-access=yes
/snmp
set contact="" enabled=yes engine-id="" location="Alta Barda / Neuqu\E9n" \
    trap-community=tppar trap-target=0.0.0.0 trap-version=1
/system logging action
set memory memory-lines=100 memory-stop-on-full=no name=memory target=memory
set disk disk-file-count=2 disk-file-name=log disk-lines-per-file=100 \
    disk-stop-on-full=no name=disk target=disk
set echo name=echo remember=yes target=echo
set remote bsd-syslog=no name=remote remote-port=514 syslog-facility=daemon \
    syslog-severity=auto target=remote
/system routerboard settings
set boot-device=nand-if-fail-then-ethernet boot-protocol=bootp cpu-frequency=\
    400MHz force-backup-booter=no silent-boot=no
set boot-device=nand-if-fail-then-ethernet boot-protocol=bootp cpu-frequency=\
    400MHz force-backup-booter=no silent-boot=no
/user group
add name=read policy="local,telnet,ssh,reboot,read,test,winbox,password,web,sn\
    iff,sensitive,api,!ftp,!write,!policy" skin=default
add name=write policy="local,telnet,ssh,reboot,read,write,test,winbox,password\
    ,web,sniff,sensitive,api,!ftp,!policy" skin=default
add name=full policy="local,telnet,ssh,ftp,reboot,read,write,policy,test,winbo\
    x,password,web,sniff,sensitive,api" skin=default
add name=ftp policy="local,telnet,ssh,ftp,reboot,read,write,policy,test,winbox\
    ,password,web,sniff,sensitive,api" skin=default
/interface bridge settings
set use-ip-firewall=no use-ip-firewall-for-pppoe=no use-ip-firewall-for-vlan=\
    no
/interface ethernet switch port
set ether1-gateway vlan-mode=disabled
set Salida_Internet_Port_2 vlan-mode=disabled
set Ingreso_morosos_Port_3 vlan-mode=disabled
set ether4-slave-local vlan-mode=disabled
set edsdsdther5-slave-local vlan-mode=disabled
set switch1_cpu vlan-mode=disabled
/interface l2tp-server server
set authentication=pap,chap,mschap1,mschap2 default-profile=\
    default-encryption enabled=no max-mru=1460 max-mtu=1460 mrru=disabled
/interface ovpn-server server
set auth=sha1,md5 certificate=none cipher=blowfish128,aes128 default-profile=\
    default enabled=no keepalive-timeout=60 mac-address=FE:78:98:22:7D:57 \
    max-mtu=1500 mode=ip netmask=24 port=1194 require-client-certificate=no
/interface pptp-server server
set authentication=mschap1,mschap2 default-profile=default-encryption \
    enabled=yes keepalive-timeout=30 max-mru=1460 max-mtu=1460 mrru=disabled
/interface sstp-server server
set authentication=pap,chap,mschap1,mschap2 certificate=none default-profile=\
    default enabled=no keepalive-timeout=60 max-mru=1500 max-mtu=1500 mrru=\
    disabled port=443 verify-client-certificate=no
/ip accounting
set account-local-traffic=no enabled=no threshold=256
/ip accounting web-access
set accessible-via-web=no address=0.0.0.0/0
/ip address
add address=172.40.131.26/24 disabled=yes interface=Ingreso_morosos_Port_3 \
    network=172.40.131.0
add address=172.16.0.26/22 disabled=no interface=Ingreso_morosos_Port_3 \
    network=172.16.0.0
add address=10.14.128.253/22 disabled=no interface=Salida_Internet_Port_2 \
    network=10.14.128.0
add address=190.14.174.66/26 disabled=no interface=vlan1 network=\
    190.14.174.64
/ip dhcp-server config
set store-leases-disk=5m
/ip dns
set allow-remote-requests=yes cache-max-ttl=1w cache-size=2048KiB \
    max-udp-packet-size=512 servers=200.69.193.1,200.69.193.1
/ip dns static
add address=8.8.8.8 disabled=no name=router ttl=1d
/ip firewall address-list
add address=172.40.111.27-172.40.111.254 disabled=yes list=morosos
add address=172.40.131.27-172.40.131.254 disabled=yes list=morosos
add address=172.16.0.27-172.16.254.254 disabled=no list=morosos
/ip firewall connection tracking
set enabled=yes generic-timeout=10m icmp-timeout=10s tcp-close-timeout=10s \
    tcp-close-wait-timeout=10s tcp-established-timeout=1d \
    tcp-fin-wait-timeout=10s tcp-last-ack-timeout=10s \
    tcp-syn-received-timeout=5s tcp-syn-sent-timeout=5s tcp-syncookie=no \
    tcp-time-wait-timeout=10s udp-stream-timeout=3m udp-timeout=10s
/ip firewall filter
add action=accept chain=forward disabled=no dst-port=53 protocol=udp \
    src-address-list=morosos
add action=accept chain=forward disabled=no dst-address-list=morosos \
    protocol=udp src-port=53
add action=drop chain=forward disabled=yes src-address-list=morosos
/ip firewall nat
add action=masquerade chain=srcnat comment="default configuration" disabled=\
    no
add action=redirect chain=dstnat disabled=no dst-port=0-65535 protocol=tcp \
    src-address-list=morosos to-ports=8080
/ip firewall service-port
set ftp disabled=no ports=21
set tftp disabled=no ports=69
set irc disabled=no ports=6667
set h323 disabled=no
set sip disabled=no ports=5060,5061
set pptp disabled=no
/ip hotspot service-port
set ftp disabled=no ports=21
/ip neighbor discovery
set ether1-gateway discover=no
set Salida_Internet_Port_2 discover=yes
set Ingreso_morosos_Port_3 discover=yes
set ether4-slave-local discover=yes
set edsdsdther5-slave-local discover=yes
set vlan1 discover=no
/ip proxy
set always-from-cache=no cache-administrator=webmaster cache-hit-dscp=4 \
    cache-on-disk=no enabled=yes max-cache-size=none max-client-connections=\
    2500 max-fresh-time=3d max-server-connections=2500 parent-proxy=0.0.0.0 \
    parent-proxy-port=0 port=8080 serialize-connections=no src-address=\
    0.0.0.0
/ip proxy access
add action=allow disabled=no dst-address=190.2.46.242
add action=allow disabled=no dst-address=190.183.222.132
add action=allow disabled=no dst-address=70.42.56.25
add action=allow disabled=no dst-address=70.42.56.26
add action=allow disabled=no dst-address=74.63.209.43
add action=deny disabled=no
/ip route
add disabled=no distance=1 dst-address=0.0.0.0/0 gateway=190.14.174.65 scope=\
    30 target-scope=10
add disabled=no distance=2 dst-address=0.0.0.0/0 gateway=10.14.128.1 scope=30 \
    target-scope=10
/ip service
set telnet disabled=no port=23
set ftp disabled=no port=21
set www disabled=no port=80
set ssh address=200.68.72.101/32 disabled=no port=22
set www-ssl certificate=none disabled=yes port=443
set api disabled=yes port=8728
set winbox disabled=no port=8291
/ip socks
set connection-idle-timeout=2m enabled=no max-connections=200 port=1080
/ip ssh
set forwarding-enabled=no
/ip traffic-flow
set active-flow-timeout=30m cache-entries=4k enabled=no \
    inactive-flow-timeout=15s interfaces=all
/ip upnp
set allow-disable-external-interface=yes enabled=no show-dummy-rule=yes
/mpls
set dynamic-label-range=16-1048575 propagate-ttl=yes
/mpls interface
add disabled=no interface=all mpls-mtu=1508
/mpls ldp
set distribute-for-default-route=no enabled=no hop-limit=255 loop-detect=no \
    lsr-id=0.0.0.0 path-vector-limit=255 transport-address=0.0.0.0 \
    use-explicit-null=no
/port firmware
set directory=firmware
/ppp aaa
set accounting=yes interim-update=0s use-radius=no
/ppp secret
add caller-id="" disabled=no limit-bytes-in=0 limit-bytes-out=0 \
    local-address=10.14.128.253 name=1234 password=1234 remote-address=\
    10.14.128.102 routes="" service=pptp
/queue interface
set ether1-gateway queue=ethernet-default
set Salida_Internet_Port_2 queue=ethernet-default
set Ingreso_morosos_Port_3 queue=ethernet-default
set ether4-slave-local queue=ethernet-default
set edsdsdther5-slave-local queue=ethernet-default
/radius incoming
set accept=no port=3799
/routing bfd interface
set all disabled=no interface=all interval=0.2sec min-rx=0.2sec multiplier=5
/routing mme
set bidirectional-timeout=2 gateway-class=none gateway-keepalive=1m \
    gateway-selection=no-gateway origination-interval=5s preferred-gateway=\
    0.0.0.0 timeout=1m ttl=50
/routing rip
set distribute-default=never garbage-timer=2m metric-bgp=1 metric-connected=1 \
    metric-default=1 metric-ospf=1 metric-static=1 redistribute-bgp=no \
    redistribute-connected=no redistribute-ospf=no redistribute-static=no \
    routing-table=main timeout-timer=3m update-timer=30s
/store
add disabled=no disk=system name=web-proxy1 type=web-proxy
/system clock
set time-zone-name=America/Argentina/Buenos_Aires
/system clock manual
set dst-delta=+00:00 dst-end="jan/01/1970 00:00:00" dst-start=\
    "jan/01/1970 00:00:00" time-zone=+00:00
/system console
add disabled=no term=vt102
/system health
set
/system identity
set name=MikroTik
/system logging
add action=memory disabled=no prefix="" topics=info
add action=memory disabled=no prefix="" topics=error
add action=memory disabled=no prefix="" topics=warning
add action=echo disabled=no prefix="" topics=critical
/system note
set note="" show-at-login=yes
/system ntp client
set enabled=no mode=broadcast primary-ntp=0.0.0.0 secondary-ntp=0.0.0.0
/system resource irq
set 0 cpu=auto
set 1 cpu=auto
/system scheduler
add disabled=no interval=1d name=backup on-event="export file=bkp-nq" policy=\
    ftp,reboot,read,write,policy,test,winbox,password,sniff,sensitive,api \
    start-date=jul/26/2013 start-time=14:53:00
/system script
add name=e-mail-backup policy=\
    ftp,reboot,read,write,policy,test,winbox,password,sniff,sensitive,api \
    source="/system backup save name=today;\
    \n/tool e-mail send to=\"ngn@tpp.com.ar\" subject=([/system identity get n\
    ame].\" backup\") file=today.backup;\
    \n:log info \"Backup e-mail sent.\";  "
/system upgrade mirror
set check-interval=1d enabled=no primary-server=0.0.0.0 secondary-server=\
    0.0.0.0 user=""
/system watchdog
set auto-send-supout=no automatic-supout=yes no-ping-delay=5m watch-address=\
    none watchdog-timer=yes
/tool bandwidth-server
set allocate-udp-ports-from=2000 authenticate=no enabled=no max-sessions=100
/tool e-mail
set address=192.168.0.5 from=prtgmonitor@tpp.com.ar password="" port=25 user=\
    ""
/tool graphing
set page-refresh=300 store-every=5min
/tool mac-server
set (unknown) disabled=no interface=Salida_Internet_Port_2
set (unknown) disabled=no interface=Ingreso_morosos_Port_3
set (unknown) disabled=no interface=ether4-slave-local
set (unknown) disabled=no interface=edsdsdther5-slave-local
/tool mac-server ping
set enabled=yes
/tool sms
set allowed-number="" channel=0 keep-max-sms=0 receive-enabled=no secret=""
/tool sniffer
set file-limit=10 file-name="" filter-address1=0.0.0.0/0:0-65535 \
    filter-address2=0.0.0.0/0:0-65535 filter-protocol=all-frames \
    filter-stream=yes interface=all memory-limit=10 memory-scroll=yes \
    only-headers=no streaming-enabled=no streaming-server=0.0.0.0
/tool traffic-generator
set latency-distribution-scale=10 test-id=0
/tool traffic-monitor
add disabled=yes interface=Salida_Internet_Port_2 name=tmon1 on-event="" \
    threshold=0 traffic=received trigger=above
/user aaa
set accounting=yes default-group=read interim-update=0s use-radius=no
