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
        address 10.100.128.1/19
        address 190.14.191.193/29
        address 10.15.128.1/19
        address 10.30.128.1/24
        description LAN
        duplex full
        hw-id 5c:f3:fc:f2:0c:ce
        smp_affinity auto
        speed 1000
        vif 15 {
            address 10.15.15.1/16
            address 10.200.128.1/24
        }
        vif 20 {
            address 10.20.128.1/19
            address 190.14.173.1/24
        }
        vif 30 {
            address 10.31.128.1/19
            address 190.14.163.1/24
            address 190.14.168.1/23
            address 190.14.188.1/23
            address 190.14.186.1/23
            address 190.14.184.1/23
            address 190.114.146.1/24
            address 190.14.190.1/24
            address 190.14.191.1/25
            address 190.14.160.1/24
            address 190.114.144.1/24
            address 190.114.148.1/24
            address 190.14.161.1/24
            address 190.14.162.1/24
            address 190.114.168.1/24
            address 190.114.188.1/24
            address 190.114.183.1/24
            address 181.225.2.1/24
            address 181.225.3.1/24
        }
        vif 160 {
            address 10.15.160.1/24
            address 10.15.161.1/28
        }
    }
    ethernet eth1 {
        description WAN
        duplex full
        hw-id 5c:f3:fc:f2:0c:cf
        smp_affinity auto
        speed 1000
        vif 428 {
            address 200.51.216.238/30
        }
    }
    loopback lo {
    }
}
nat {
    destination {
        rule 12 {
            description MuxApparTV
            destination {
                address 190.14.163.253
            }
            inbound-interface eth1.428
            translation {
                address 10.15.160.2
            }
        }
        rule 13 {
            description MuxStreamTel
            destination {
                address 190.14.163.254
            }
            inbound-interface eth1.428
            translation {
                address 10.15.160.5
            }
        }
        rule 19 {
            description EPGServer
            destination {
                address 190.14.163.251
            }
            inbound-interface eth1.428
            translation {
                address 10.15.160.6
            }
        }
        rule 40 {
            description NatPrizm
            destination {
                address 190.14.163.252
            }
            inbound-interface eth1.428
            translation {
                address 10.15.128.4
            }
        }
    }
    source {
        rule 20 {
            description NatOutsideCanlDelVientoNet
            destination {
                address !10.10.128.0/17
            }
            outbound-interface eth1.428
            source {
                address 10.15.160.0/24
            }
            translation {
                address 190.14.163.250
            }
        }
    }
}
protocols {
    static {
        route 0.0.0.0/0 {
            next-hop 200.51.216.237 {
            }
        }
        route 10.22.128.0/24 {
            next-hop 10.15.128.18 {
            }
        }
        route 10.40.0.0/16 {
            next-hop 10.15.128.24 {
            }
        }
        route 10.50.128.0/24 {
            next-hop 10.15.128.6 {
            }
        }
        route 10.100.128.0/24 {
            next-hop 190.14.173.234 {
            }
        }
        route 10.115.40.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 10.140.141.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 10.141.141.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 10.215.110.0/24 {
            next-hop 10.30.128.110 {
            }
        }
        route 10.215.111.0/24 {
            next-hop 10.30.128.111 {
            }
        }
        route 10.215.112.0/24 {
            next-hop 10.30.128.112 {
            }
        }
        route 10.215.113.0/24 {
            next-hop 10.30.128.113 {
            }
        }
        route 10.215.120.0/24 {
            next-hop 10.30.128.120 {
            }
        }
        route 10.215.121.0/24 {
            next-hop 10.30.128.121 {
            }
        }
        route 10.215.122.0/24 {
            next-hop 10.30.128.122 {
            }
        }
        route 10.215.123.0/24 {
            next-hop 10.30.128.123 {
            }
        }
        route 10.215.124.0/24 {
            next-hop 10.30.128.124 {
            }
        }
        route 10.215.129.0/24 {
            next-hop 10.15.128.129 {
            }
        }
        route 10.215.130.0/24 {
            next-hop 10.15.128.130 {
            }
        }
        route 10.215.131.0/24 {
            next-hop 10.15.128.131 {
            }
        }
        route 10.215.132.0/24 {
            next-hop 10.15.128.132 {
            }
        }
        route 10.215.133.0/24 {
            next-hop 10.15.128.133 {
            }
        }
        route 10.215.134.0/24 {
            next-hop 10.15.128.134 {
            }
        }
        route 10.215.138.0/24 {
            next-hop 10.15.128.138 {
            }
        }
        route 10.215.139.0/24 {
            next-hop 10.15.128.139 {
            }
        }
        route 10.215.140.0/24 {
            next-hop 10.15.128.140 {
            }
        }
        route 10.215.141.0/24 {
            next-hop 10.15.128.141 {
            }
        }
        route 10.215.142.0/24 {
            next-hop 10.15.128.142 {
            }
        }
        route 10.215.143.0/24 {
            next-hop 10.15.128.143 {
            }
        }
        route 10.215.144.0/24 {
            next-hop 10.15.128.144 {
            }
        }
        route 10.215.145.0/24 {
            next-hop 10.15.128.145 {
            }
        }
        route 10.215.146.0/24 {
            next-hop 10.15.128.146 {
            }
        }
        route 10.215.147.0/24 {
            next-hop 10.15.128.147 {
            }
        }
        route 10.215.148.0/24 {
            next-hop 10.15.128.148 {
            }
        }
        route 10.215.149.0/24 {
            next-hop 10.15.128.149 {
            }
        }
        route 10.215.150.0/24 {
            next-hop 10.15.128.150 {
            }
        }
        route 10.215.151.0/24 {
            next-hop 10.15.128.151 {
            }
        }
        route 10.215.152.0/24 {
            next-hop 10.15.128.152 {
            }
        }
        route 10.215.153.0/24 {
            next-hop 10.15.128.153 {
            }
        }
        route 10.215.171.0/24 {
            next-hop 10.15.128.171 {
            }
        }
        route 10.215.172.0/24 {
            next-hop 10.15.128.172 {
            }
        }
        route 10.215.173.0/24 {
            next-hop 10.15.128.173 {
            }
        }
        route 10.215.174.0/24 {
            next-hop 10.15.128.174 {
            }
        }
        route 10.215.175.0/24 {
            next-hop 10.15.128.175 {
            }
        }
        route 10.215.176.0/24 {
            next-hop 10.15.128.176 {
            }
        }
        route 10.215.177.0/24 {
            next-hop 10.15.128.177 {
            }
        }
        route 10.215.178.0/24 {
            next-hop 10.15.128.178 {
            }
        }
        route 10.215.191.0/24 {
            next-hop 10.15.128.191 {
            }
        }
        route 10.215.192.0/24 {
            next-hop 10.15.128.192 {
            }
        }
        route 10.215.193.0/24 {
            next-hop 10.15.128.193 {
            }
        }
        route 10.215.199.0/24 {
            next-hop 10.15.128.199 {
            }
        }
        route 10.215.202.0/24 {
            next-hop 10.15.128.202 {
            }
        }
        route 10.215.203.0/24 {
            next-hop 10.15.128.203 {
            }
        }
        route 10.215.204.0/24 {
            next-hop 10.15.128.204 {
            }
        }
        route 10.215.205.0/24 {
            next-hop 10.15.128.205 {
            }
        }
        route 10.215.206.0/24 {
            next-hop 10.15.128.206 {
            }
        }
        route 10.215.209.0/24 {
            next-hop 10.15.128.209 {
            }
        }
        route 10.215.210.0/24 {
            next-hop 10.15.128.210 {
            }
        }
        route 10.215.211.0/24 {
            next-hop 10.15.128.211 {
            }
        }
        route 10.215.212.0/24 {
            next-hop 10.15.128.212 {
            }
        }
        route 10.215.218.0/24 {
            next-hop 10.15.128.218 {
            }
        }
        route 10.215.219.0/24 {
            next-hop 10.15.128.219 {
            }
        }
        route 10.215.220.0/24 {
            next-hop 10.15.128.220 {
            }
        }
        route 10.215.241.0/24 {
            next-hop 10.15.128.241 {
            }
        }
        route 10.215.242.0/24 {
            next-hop 10.15.128.242 {
            }
        }
        route 10.215.243.0/24 {
            next-hop 10.15.128.243 {
            }
        }
        route 10.215.245.0/24 {
            next-hop 10.15.128.245 {
            }
        }
        route 10.215.249.0/24 {
            next-hop 10.15.128.249 {
            }
        }
        route 10.230.93.0/24 {
            next-hop 10.30.128.93 {
            }
        }
        route 10.230.94.0/24 {
            next-hop 10.30.128.94 {
            }
        }
        route 10.230.95.0/24 {
            next-hop 10.30.128.95 {
            }
        }
        route 10.230.96.0/24 {
            next-hop 10.30.128.96 {
            }
        }
        route 10.230.97.0/24 {
            next-hop 10.30.128.97 {
            }
        }
        route 10.230.98.0/24 {
            next-hop 10.30.128.98 {
            }
        }
        route 10.230.124.0/24 {
            next-hop 10.30.128.124 {
            }
        }
        route 10.230.126.0/24 {
            next-hop 10.30.128.126 {
            }
        }
        route 10.230.128.0/24 {
            next-hop 10.30.128.128 {
            }
        }
        route 10.230.129.0/24 {
            next-hop 10.30.128.129 {
            }
        }
        route 10.230.130.0/24 {
            next-hop 10.30.128.130 {
            }
        }
        route 10.230.131.0/24 {
            next-hop 10.30.128.131 {
            }
        }
        route 10.230.132.0/24 {
            next-hop 10.30.128.132 {
            }
        }
        route 10.230.133.0/24 {
            next-hop 10.30.128.133 {
            }
        }
        route 10.230.134.0/24 {
            next-hop 10.30.128.134 {
            }
        }
        route 10.230.135.0/24 {
            next-hop 10.30.128.135 {
            }
        }
        route 10.230.137.0/24 {
            next-hop 10.30.128.137 {
            }
        }
        route 10.230.150.0/24 {
            next-hop 10.30.128.150 {
            }
        }
        route 10.230.151.0/24 {
            next-hop 10.30.128.151 {
            }
        }
        route 10.230.152.0/24 {
            next-hop 10.30.128.152 {
            }
        }
        route 10.230.161.0/24 {
            next-hop 10.30.128.161 {
            }
        }
        route 10.230.165.0/24 {
            next-hop 10.30.128.165 {
            }
        }
        route 10.230.166.0/24 {
            next-hop 10.30.128.166 {
            }
        }
        route 10.230.167.0/24 {
            next-hop 10.30.128.167 {
            }
        }
        route 10.230.168.0/24 {
            next-hop 10.30.128.168 {
            }
        }
        route 10.240.0.0/16 {
            next-hop 10.15.128.24 {
            }
        }
        route 172.16.0.0/22 {
            next-hop 10.15.128.24 {
            }
        }
        route 172.40.41.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 172.40.111.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.14.164.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.14.165.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.14.166.0/23 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.14.172.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.145.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.147.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.149.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.150.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.151.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.152.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.153.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.154.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.155.0/25 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.155.128/26 {
            next-hop 10.40.130.50 {
            }
        }
        route 190.114.155.192/26 {
            next-hop 10.40.130.50 {
            }
        }
        route 190.114.156.0/22 {
            next-hop 10.15.128.18 {
            }
        }
        route 190.114.169.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.170.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.171.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.172.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.173.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.189.0/24 {
            next-hop 10.15.128.24 {
            }
        }
        route 190.114.190.0/24 {
            next-hop 10.15.128.24 {
            }
        }
    }
}
service {
    ssh {
        allow-root
        port 3522
        protocol-version v2
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
    host-name RouterCR-Oficina
    login {
        banner {
            pre-login "\n\n\t--------------------------------------------------------------------\n\tThese is a device property of TPP SA\n\tAll unauthorized use will be traced and prosecuted\n\tFor more information contact TPP SA +54 11 43723310 - www.tpp.com.ar\n\t--------------------------------------------------------------------\n\n\n"
        }
        user root {
            authentication {
                encrypted-password $1$kvjGCEfb$XE2GPteF9fvh3mcWfIWVG/
                plaintext-password ""
            }
            level admin
        }
        user vyatta {
            authentication {
                encrypted-password $1$3S3/yq5E$t04.fTYDnjpSHeKHt3TRo.
                plaintext-password ""
            }
            level admin
        }
    }
    ntp {
        server 0.vyatta.pool.ntp.org {
        }
        server 1.vyatta.pool.ntp.org {
        }
        server 2.vyatta.pool.ntp.org {
        }
        server 10.15.128.128 {
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
        repository debian {
            components "main contrib"
            distribution squeeze
            password ""
            url http://ftp.us.debian.org/debian
            username ""
        }
    }
    syslog {
        global {
            facility all {
                level notice
            }
            facility protocols {
                level debug
            }
        }
    }
    time-zone America/Buenos_Aires
}
traffic-policy {
    random-detect Ramdom {
        bandwidth 380mbit
    }
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "zone-policy@1:config-management@1:vrrp@1:system@5:conntrack@1:dhcp-relay@1:nat@4:ipsec@3:qos@1:webgui@1:wanloadbalance@3:cluster@1:firewall@5:webproxy@1:content-inspection@3:quagga@2:conntrack-sync@1:dhcp-server@4" === */
/* Release version: VC6.4-2012.05.31 */
