firewall {
    all-ping enable
    broadcast-ping disable
    conntrack-expect-table-size 4096
    conntrack-hash-size 4096
    conntrack-table-size 32768
    conntrack-tcp-loose enable
    ipv6-receive-redirects disable
    ipv6-src-route disable
    ip-src-route disable
    log-martians enable
    receive-redirects disable
    send-redirects enable
    source-validation disable
    syn-cookies disable
}
interfaces {
    ethernet eth2 {
        address 200.63.145.134/30
        description WAN
        duplex full
        hw-id 5c:f3:fc:2d:c6:4b
        smp_affinity auto
        speed 100
    }
    ethernet eth3 {
        address 10.24.128.1/24
        address 190.114.144.1/24
        description RED-CNPY-TPP
        duplex auto
        hw-id 5c:f3:fc:2d:c6:4c
        smp_affinity auto
        speed auto
        vif 10 {
            address 172.16.0.1/24
            description Suspencion
        }
        vif 20 {
            address 10.20.128.1/24
            address 190.114.165.1/26
            address 190.114.165.65/26
            address 190.114.165.129/26
            address 190.114.164.1/24
            description Residencial
        }
        vif 30 {
            address 10.30.128.1/24
            address 190.114.165.193/26
            description PYME
        }
    }
    loopback lo {
    }
}
protocols {
    static {
        route 0.0.0.0/0 {
            next-hop 200.63.145.133 {
            }
        }
        route 10.224.21.0/24 {
            next-hop 10.24.128.21 {
            }
        }
        route 10.224.22.0/24 {
            next-hop 10.24.128.22 {
            }
        }
        route 10.224.23.0/24 {
            next-hop 10.24.128.23 {
            }
        }
        route 10.224.24.0/24 {
            next-hop 10.24.128.24 {
            }
        }
        route 10.224.25.0/24 {
            next-hop 10.24.128.25 {
            }
        }
        route 10.224.26.0/24 {
            next-hop 10.24.128.26 {
            }
        }
    }
}
service {
    dns {
        forwarding {
            cache-size 500
            listen-on eth3
            name-server 8.8.8.8
            system
        }
    }
    snmp {
        community tppsa {
            authorization ro
            network 10.10.128.0/17
        }
        listen-address 10.24.128.1 {
            port 161
        }
    }
    ssh {
        allow-root
        port 3522
        protocol-version all
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
    console {
        device ttyS0 {
            speed 9600
        }
    }
    host-name RtrZapala
    login {
        radius-server 10.10.128.124 {
            port 1812
            secret nasvyatta
            timeout 30
        }
        user clepore {
            authentication {
                encrypted-password $1$N.IC0lKY$gbJbgTMjV5vWNw0HLbJ2f.
                plaintext-password ""
            }
            level admin
        }
        user mrighetti {
            authentication {
                encrypted-password $1$ProRnOGk$nKbUHfGvIuN6u0TKTBgbv.
                plaintext-password ""
            }
            level admin
        }
        user vyatta {
            authentication {
                encrypted-password $1$pUGFUL8s$Qu35/IFqjMYFOi4v51m/V1
                plaintext-password ""
            }
            level admin
        }
        user zp-admtpp {
            authentication {
                encrypted-password $1$1ci01lLz$Ek76Z2.vK0/aIjD51N19R/
            }
            level admin
        }
    }
    name-server 8.8.8.8
    name-server 8.8.4.4
    ntp {
        server 0.vyatta.pool.ntp.org {
        }
        server 1.vyatta.pool.ntp.org {
        }
        server 2.vyatta.pool.ntp.org {
        }
        server 10.24.128.20 {
            prefer
        }
    }
    options {
        reboot-on-panic true
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
                level notice
            }
            facility protocols {
                level debug
            }
        }
    }
    time-zone America/Argentina/Buenos_Aires
}
vpn {
    ipsec {
        esp-group ESP-1ZP {
            compression disable
            lifetime 1800
            mode tunnel
            pfs enable
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption 3des
                hash md5
            }
        }
        ike-group IKE-1ZP {
            lifetime 3600
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption aes256
                hash sha1
            }
        }
        ipsec-interfaces {
            interface eth3
        }
        site-to-site {
            peer 190.2.46.194 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret tppvpnzp
                }
                connection-type initiate
                ike-group IKE-1ZP
                local-ip 190.114.164.1
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ZP
                    local {
                        subnet 10.24.128.0/24
                    }
                    remote {
                        subnet 10.10.128.0/17
                    }
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ZP
                    local {
                        subnet 10.224.0.0/16
                    }
                    remote {
                        subnet 10.10.128.0/17
                    }
                }
                tunnel 3 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ZP
                    local {
                        subnet 10.24.128.0/24
                    }
                    remote {
                        subnet 192.168.0.0/16
                    }
                }
            }
        }
    }
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "qos@1:webproxy@1:config-management@1:wanloadbalance@3:dhcp-relay@1:content-inspection@3:nat@3:conntrack-sync@1:quagga@2:firewall@4:zone-policy@1:system@4:vrrp@1:cluster@1:dhcp-server@4:webgui@1:ipsec@3" === */
/* Release version: VC6.3-2011.07.21 */
