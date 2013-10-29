firewall {
    all-ping enable
    broadcast-ping disable
    ipv6-receive-redirects disable
    ipv6-src-route disable
    ip-src-route enable
    log-martians enable
    receive-redirects enable
    send-redirects enable
    source-validation disable
    syn-cookies enable
}
interfaces {
    ethernet eth0 {
        address 200.68.72.101/29
        description "Iplan Internet-port 1 sw Iplan"
        duplex auto
        hw-id 40:f2:e9:07:ad:d2
        smp_affinity auto
        speed auto
        traffic-policy {
            out Congestion
        }
        vif 1 {
            disable
        }
    }
    ethernet eth1 {
        address 172.18.18.2/30
        description "TLS Viamonte-port 20 sw Iplan"
        duplex auto
        hw-id 40:f2:e9:07:ad:d3
        smp_affinity auto
        speed auto
        traffic-policy {
            out Congestion
        }
    }
    ethernet eth2 {
        description DNS-10.77.128.1-201.216.254.105
        duplex auto
        hw-id 40:f2:e9:07:ad:d4
        smp_affinity auto
        speed auto
        vif 7 {
            address 10.77.128.1/24
            address 201.216.254.105/29
            description DNS
        }
    }
    ethernet eth3 {
        description "Sw Penales port 1"
        duplex auto
        hw-id 40:f2:e9:07:ad:d5
        smp_affinity auto
        speed auto
        vif 4 {
            address 10.10.127.1/24
            address 10.10.129.1/28
            description "link Viamonte"
        }
        vif 60 {
            address 10.86.128.1/24
            description "Vlan Prueba Penales"
        }
    }
    ethernet eth4 {
        description "UMG8900-OMC-slot 1-MNG"
        duplex full
        hw-id 90:e2:ba:40:4b:84
        smp_affinity auto
        speed 100
        vif 4 {
        }
    }
    ethernet eth5 {
        description "UMG8900-FE0-Slot 3"
        duplex auto
        hw-id 90:e2:ba:40:4b:85
        smp_affinity auto
        speed auto
        vif 3 {
            description "link UMG"
        }
    }
    ethernet eth6 {
        description "UMG8900-VPU-FE0-RTP-Slot 1"
        duplex auto
        hw-id 90:e2:ba:40:4b:86
        smp_affinity auto
        speed auto
        vif 3 {
            address 201.216.254.97/29
            description "link UMG"
        }
    }
    ethernet eth7 {
        description "Mux G. Catan-interface bridge"
        duplex auto
        hw-id 90:e2:ba:40:4b:87
        smp_affinity auto
        speed auto
        vif 4 {
            description "link Viamonte"
        }
    }
    ethernet eth8 {
        description "Mux San Martin-interface bridge"
        duplex auto
        hw-id 90:e2:ba:40:51:dc
        smp_affinity auto
        speed auto
        vif 4 {
            description "link Viamonte"
        }
    }
    ethernet eth9 {
        duplex auto
        hw-id 90:e2:ba:40:51:dd
        smp_affinity auto
        speed auto
    }
    ethernet eth10 {
        description "Vlan prueba G. Catan"
        duplex auto
        hw-id 90:e2:ba:40:51:de
        smp_affinity auto
        speed auto
        vif 60 {
        }
    }
    ethernet eth11 {
        address 55.10.10.66/24
        duplex auto
        hw-id 90:e2:ba:40:51:df
        smp_affinity auto
        speed auto
    }
    loopback lo {
    }
}
nat {
    destination {
        rule 2 {
            description Nat_Inside
            destination {
                address 200.68.72.101
            }
            inbound-interface eth0
            translation {
                address 172.18.18.2
            }
        }
        rule 10 {
            description "Nat_inside Vlan 4"
            destination {
                address 200.68.72.101
            }
            inbound-interface eth0
            translation {
                address 10.10.129.1
            }
        }
        rule 11 {
            description "Nat_inside Vlan 4_127"
            destination {
                address 200.68.72.101
            }
            inbound-interface eth0
            translation {
                address 10.10.127.1
            }
        }
        rule 20 {
            description "Nat_inside Vlan 7_10.77"
            destination {
                address 201.216.254.105
            }
            inbound-interface eth0
            translation {
                address 10.77.128.1
            }
        }
        rule 60 {
            description "Nat_inside Vlan 60_10.86.128"
            destination {
                address 200.68.72.101
            }
            inbound-interface eth0
            translation {
                address 10.86.128.1
            }
        }
    }
    source {
        rule 1 {
            description NAT_Outside_eth0
            outbound-interface eth0
            protocol all
            source {
                address 172.18.18.2/30
            }
            translation {
                address 200.68.72.101-200.68.72.102
            }
        }
        rule 30 {
            description Nat_Overload
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.10.128.0/17
            }
            translation {
                address masquerade
            }
        }
        rule 40 {
            description Nat_Overload_172.16
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 172.16.1.0/24
            }
            translation {
                address masquerade
            }
        }
        rule 70 {
            description Nat_Overload_192.168
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 192.168.0.0/17
            }
            translation {
                address masquerade
            }
        }
        rule 80 {
            description Nat_Overload_10.10.127.117
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.10.127.117
            }
            translation {
                address masquerade
            }
        }
        rule 81 {
            description Nat_Overload_10.10.127.233
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.10.127.233
            }
            translation {
                address masquerade
            }
        }
        rule 82 {
            description Nat_Overload_10.10.127.193
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.10.127.193
            }
            translation {
                address masquerade
            }
        }
        rule 83 {
            description Nat_Overload_10.10.127.132
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.10.127.132
            }
            translation {
                address masquerade
            }
        }
        rule 84 {
            description Nat_Overload_10.10.127.144
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.10.127.144
            }
            translation {
                address masquerade
            }
        }
        rule 85 {
            description Nat_Overload_10.77.128.1
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.77.128.1
            }
            translation {
                address masquerade
            }
        }
        rule 86 {
            description Nat_Overload_10.77.128.2
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.77.128.2
            }
            translation {
                address masquerade
            }
        }
        rule 87 {
            description Nat_Overload_10.77.128.3
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.77.128.3
            }
            translation {
                address masquerade
            }
        }
        rule 88 {
            description Nat_Overload_10.77.128.4
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.77.128.4
            }
            translation {
                address masquerade
            }
        }
        rule 89 {
            description Nat_Overload_10.77.128.5
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol all
            source {
                address 10.77.128.5
            }
            translation {
                address masquerade
            }
        }
        rule 90 {
            description NAT_TS_Lepore
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol tcp
            source {
                address 10.10.128.248
                port 3389
            }
            translation {
                address 200.68.72.101
                port 3389
            }
        }
        rule 91 {
            description NAT_TS_10.10.128.4
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol tcp
            source {
                address 10.10.128.4
                port 5948
            }
            translation {
                address 200.68.72.101
                port 5948
            }
        }
        rule 92 {
            description NAT_TS_10.10.128.212-1
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol tcp
            source {
                address 10.10.128.212
                port 5847
            }
            translation {
                address 200.68.72.101
                port 6847
            }
        }
        rule 93 {
            description NAT_TS_10.10.128.212-2
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol tcp
            source {
                address 10.10.128.212
                port 5947
            }
            translation {
                address 200.68.72.101
                port 6947
            }
        }
        rule 95 {
            description NAT_TS_10.10.1.200
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol tcp
            source {
                address 10.10.1.200
                port 5900
            }
            translation {
                address 200.68.72.101
                port 6948
            }
        }
        rule 96 {
            description NAT_TS_10.10.128.212-3
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol tcp
            source {
                address 10.10.128.212
                port 8080
            }
            translation {
                address 200.68.72.101
                port 8888
            }
        }
        rule 97 {
            description NAT_TS_10.10.128.128-PRTG
            destination {
                address 0.0.0.0/0
            }
            outbound-interface eth0
            protocol tcp
            source {
                address 10.10.128.128
                port 8080
            }
            translation {
                address 200.68.72.101
                port 8888
            }
        }
    }
}
protocols {
    static {
        route 0.0.0.0/0 {
            next-hop 200.68.72.102 {
            }
        }
        route 10.8.10.0/24 {
            next-hop 172.18.18.1 {
            }
        }
        route 10.10.1.192/27 {
            next-hop 172.18.18.1 {
            }
        }
        route 10.10.10.0/24 {
            next-hop 172.18.18.1 {
            }
        }
        route 10.10.128.0/17 {
            next-hop 172.18.18.1 {
            }
        }
        route 10.11.128.0/19 {
            next-hop 172.18.18.1 {
            }
        }
        route 10.12.128.0/19 {
            next-hop 10.10.0.1 {
            }
        }
        route 10.15.128.0/19 {
            next-hop 172.18.18.1 {
            }
        }
        route 10.16.128.0/19 {
            next-hop 10.10.128.90 {
            }
            next-hop 10.10.255.254 {
            }
        }
        route 10.24.128.0/24 {
            next-hop 10.10.128.90 {
            }
        }
        route 10.30.128.0/22 {
            next-hop 172.18.18.1 {
            }
        }
        route 172.16.0.0/16 {
            next-hop 172.18.18.1 {
            }
        }
        route 190.2.46.192/29 {
            next-hop 172.18.18.1 {
            }
        }
        route 190.2.46.200/30 {
            next-hop 10.10.127.131 {
            }
        }
        route 190.2.46.204/30 {
            next-hop 10.10.127.132 {
            }
        }
        route 190.2.46.208/30 {
            next-hop 10.10.127.193 {
            }
        }
        route 190.2.46.212/30 {
            next-hop 10.10.127.137 {
            }
        }
        route 190.2.46.216/30 {
            next-hop 10.10.127.138 {
            }
        }
        route 190.2.46.220/30 {
            next-hop 10.10.127.117 {
            }
        }
        route 190.2.46.240/28 {
            next-hop 172.18.18.1 {
            }
        }
        route 190.12.101.143/32 {
            next-hop 172.18.18.1 {
            }
        }
        route 190.12.101.144/32 {
            next-hop 172.18.18.1 {
            }
        }
        route 192.168.0.0/17 {
            next-hop 172.18.18.1 {
            }
        }
        route 200.73.185.64/27 {
            next-hop 172.18.18.1 {
            }
        }
    }
}
service {
    snmp {
        community tppsa {
            authorization ro
        }
        contact "TPP NGN - Email:ngn@tpp.com.ar - Web:www.tpp.com.ar"
        description Vyatta-Artigas
        location "Nodo Artigas-CABA"
    }
    ssh {
        allow-root
        port 3522
    }
    telnet {
        allow-root
        port 23
    }
}
system {
    config-management {
        commit-revisions 20
    }
    conntrack {
        expect-table-size 625000
        hash-size 625000
        table-size 50000000
    }
    console {
        device ttyS0 {
            speed 9600
        }
    }
    domain-name ba-02-ats.tpp.com.ar
    host-name Artigas
    login {
        banner {
            pre-login "\n\n\t--------------------------------------------------------------------\n\tThese is a device property of TPP SA\n\tAll unauthorized use will be traced and prosecuted\n\tFor more information contact TPP SA +54 11 43723310 - www.tpp.com.ar\n\t--------------------------------------------------------------------\n\n\n"
        }
        user root {
            authentication {
                encrypted-password $1$QqyrbsYt$S1jOYvRhR.OC74dgANfB6.
                plaintext-password ""
            }
            level admin
        }
        user vyatta {
            authentication {
                encrypted-password $1$TEYXqM20$MmI1/lJcjkZwBAa4AN6Ya/
            }
            level admin
        }
    }
    name-server 200.69.193.1
    name-server 200.69.193.2
    ntp {
        server 0.vyatta.pool.ntp.org {
        }
        server 1.vyatta.pool.ntp.org {
        }
        server 2.vyatta.pool.ntp.org {
        }
    }
    package {
        auto-sync 1
        repository community {
            components main
            distribution stable
            password ""
            url http://packages.vyatta.com/vyatta
            username ""
        }
    }
    syslog {
        global {
            facility all {
                level crit
            }
            facility mark {
                level warning
            }
            facility protocols {
                level debug
            }
        }
        host 10.10.128.166 {
            facility all {
                level warning
            }
        }
    }
    time-zone America/Argentina/Buenos_Aires
}
traffic-policy {
    random-detect Congestion {
        bandwidth 16mbit
    }
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "cluster@1:config-management@1:conntrack-sync@1:conntrack@1:dhcp-relay@1:dhcp-server@4:firewall@5:ipsec@4:nat@4:qos@1:quagga@2:system@6:vrrp@1:wanloadbalance@3:webgui@1:webproxy@1:zone-policy@1" === */
/* Release version: VC6.6R1 */
