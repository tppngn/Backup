interfaces {
    ethernet eth0 {
        address 190.2.46.194/27
        duplex auto
        hw-id 00:0f:1f:d7:54:05
        speed auto
    }
    ethernet eth1 {
        address 10.10.128.90/17
        duplex auto
        hw-id 00:08:54:b2:46:9c
        speed auto
    }
    loopback lo {
    }
}
protocols {
    snmp {
        community tppsa {
            authorization ro
        }
    }
    static {
        route 0.0.0.0/0 {
            next-hop 10.10.255.254 {
                distance 1
            }
        }
        route 190.14.180.1/32 {
            next-hop 10.10.0.2 {
            }
        }
        route 190.114.164.1/32 {
            next-hop 10.10.0.2 {
            }
        }
        route 192.168.0.0/17 {
            next-hop 10.10.255.253 {
            }
        }
        route 200.73.187.16/28 {
            next-hop 10.10.255.254 {
            }
        }
    }
}
service {
    ssh {
        allow-root true
        port 3522
        protocol-version v2
    }
    telnet {
        allow-root true
        port 23
    }
}
system {
    host-name vyatta-VPN-NGN
    login {
        radius-server 10.10.128.124 {
            port 1812
            secret nasvyatta
            timeout 10
        }
        user clepore {
            authentication {
                encrypted-password 1234
            }
            level admin
        }
        user fcaldiero {
            authentication {
                encrypted-password 1234
            }
            level admin
        }
        user mrighetti {
            authentication {
                encrypted-password mrighettitpp
            }
            level admin
        }
        user pguarnieri {
            authentication {
                encrypted-password 1234
            }
            level admin
        }
        user root {
            authentication {
                encrypted-password $1$yHoyQH/y$ErOv4hG6fUgrsSoxVLb451
                plaintext-password ""
            }
            level admin
        }
        user vyatta {
            authentication {
                encrypted-password $1$aYJ1Enk9$VoQuE5IL2mmK5IJIiH.r7.
                plaintext-password ""
            }
            level admin
        }
    }
    ntp-server 69.59.150.135
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
    }
    time-zone GMT
}
vpn {
    ipsec {
        copy-tos disable
        esp-group ESP-1CDR {
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
        esp-group ESP-1CUTRALCO {
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
        esp-group ESP-1ESQ {
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
        esp-group ESP-1NQ {
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
        esp-group ESP-1PIC {
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
        esp-group ESP-1SJ {
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
        esp-group ESP-1VILLANUEVA {
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
        esp-group ESP-2COL {
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
        ike-group IKE-1CDR {
            aggressive-mode disable
            lifetime 3600
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption aes128
                hash sha1
            }
        }
        ike-group IKE-1CUTRALCO {
            aggressive-mode disable
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
        ike-group IKE-1ESQ {
            aggressive-mode disable
            lifetime 3600
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption aes128
                hash sha1
            }
        }
        ike-group IKE-1NQ {
            aggressive-mode disable
            lifetime 3600
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption aes128
                hash sha1
            }
        }
        ike-group IKE-1PIC {
            aggressive-mode disable
            lifetime 3600
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption aes128
                hash sha1
            }
        }
        ike-group IKE-1SJ {
            aggressive-mode disable
            lifetime 3600
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption aes128
                hash sha1
            }
        }
        ike-group IKE-1VILLANUEVA {
            aggressive-mode disable
            lifetime 3600
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption aes128
                hash sha1
            }
        }
        ike-group IKE-1ZP {
            aggressive-mode disable
            lifetime 3600
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption aes128
                hash sha1
            }
        }
        ike-group IKE-2COL {
            aggressive-mode disable
            lifetime 3600
            proposal 1 {
                encryption aes256
                hash sha1
            }
            proposal 2 {
                encryption aes128
                hash sha1
            }
        }
        ipsec-interfaces {
            interface eth0
        }
        logging {
        }
        nat-networks {
            allowed-network 190.2.46.0/24 {
            }
        }
        nat-traversal disable
        site-to-site {
            peer 190.14.170.1 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret tppvpnsj
                }
                ike-group IKE-1SJ
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1SJ
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.11.128.0/17
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1SJ
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.12.128.0/17
                }
                tunnel 3 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1SJ
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.11.128.0/17
                }
                tunnel 4 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1SJ
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.12.128.0/17
                }
                tunnel 5 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1SJ
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.211.0.0/16
                }
                tunnel 6 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1SJ
                    local-subnet 172.18.18.0/24
                    remote-subnet 10.11.128.0/17
                }
            }
            peer 190.14.174.1 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret tppvpnnq
                }
                ike-group IKE-1NQ
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1NQ
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.14.128.0/19
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1NQ
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.14.128.0/19
                }
                tunnel 3 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1NQ
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.214.0.0/16
                }
                tunnel 4 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1NQ
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.214.0.0/16
                }
                tunnel 5 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1NQ
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.14.160.0/24
                }
                tunnel 6 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1NQ
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.14.161.0/24
                }
                tunnel 7 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1NQ
                    local-subnet 192.168.0.0/16
                    remote-subnet 10.14.161.0/24
                }
                tunnel 8 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1NQ
                    local-subnet 192.168.0.0/16
                    remote-subnet 10.14.160.0/24
                }
            }
            peer 190.14.180.1 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret VPN-CDR-CTCO
                }
                ike-group IKE-1CUTRALCO
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1CUTRALCO
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.16.128.0/19
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1CUTRALCO
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.216.0.0/16
                }
                tunnel 10 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1CUTRALCO
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.16.128.0/19
                }
                tunnel 11 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1CUTRALCO
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.216.0.0/16
                }
                tunnel 12 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1CUTRALCO
                    local-subnet 172.18.18.0/24
                    remote-subnet 10.16.128.0/24
                }
            }
            peer 190.14.190.1 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret tppvpncr
                }
                ike-group IKE-1CDR
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1CDR
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.15.128.0/19
                }
            }
            peer 190.114.133.1 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret tppvpncol
                }
                ike-group IKE-2COL
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-2COL
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.22.128.0/24
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-2COL
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.22.128.0/24
                }
                tunnel 3 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-2COL
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.222.0.0/16
                }
                tunnel 4 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-2COL
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.222.0.0/16
                }
            }
            peer 190.114.137.1 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret tppvpnpic
                }
                ike-group IKE-1PIC
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1PIC
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.18.128.0/24
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1PIC
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.18.128.0/24
                }
                tunnel 3 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1PIC
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.218.0.0/16
                }
            }
            peer 190.114.164.1 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret tppvpnzp
                }
                ike-group IKE-1ZP
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ZP
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.24.128.0/24
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ZP
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.224.0.0/16
                }
                tunnel 3 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ZP
                    local-subnet 192.168.0.0/16
                    remote-subnet 10.24.128.0/24
                }
            }
            peer 190.114.182.1 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret tppvpneq
                }
                ike-group IKE-1ESQ
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ESQ
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.26.128.0/24
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ESQ
                    local-subnet 192.168.0.0/16
                    remote-subnet 10.26.128.0/24
                }
                tunnel 3 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ESQ
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.226.0.0/16
                }
                tunnel 4 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ESQ
                    local-subnet 192.168.0.0/16
                    remote-subnet 10.226.0.0/16
                }
            }
            peer 200.63.12.129 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret VPN-CDR-VILLANUEVA
                }
                ike-group IKE-1VILLANUEVA
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1VILLANUEVA
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.30.0.0/22
                }
            }
            peer 200.63.20.94 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret VPN-CDR-VILLANUEVA
                }
                ike-group IKE-1VILLANUEVA
                local-ip 190.2.46.194
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1VILLANUEVA
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.30.0.0/22
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1VILLANUEVA
                    local-subnet 10.10.128.0/17
                    remote-subnet 10.230.12.0/24
                }
                tunnel 3 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1VILLANUEVA
                    local-subnet 10.10.0.0/24
                    remote-subnet 10.30.0.0/22
                }
                tunnel 5 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1VILLANUEVA
                    local-subnet 10.10.128.0/17
                }
                tunnel 10 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1VILLANUEVA
                    local-subnet 192.168.0.0/17
                    remote-subnet 10.30.0.0/22
                }
                tunnel 11 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1VILLANUEVA
                    local-subnet 192.168.0.0/17
                }
            }
        }
    }
    pptp {
        remote-access {
            authentication {
                local-users {
                    username clepore {
                        password diegonico
                    }
                    username conax {
                        password g6t84r
                    }
                    username fcaldiero {
                        password router2020
                    }
                    username fmenoyo {
                        password fnmtpp
                    }
                    username mrighetti {
                        password diegoarmando
                    }
                    username nzaina {
                        password supertpp
                    }
                    username pguarnieri {
                        password pablo2012tpp
                    }
                    username rniella {
                        password ak3789
                    }
                    username serverware {
                        password bicom
                    }
                    username service {
                        password service1234
                    }
                    username tppvpn {
                        password tppngn
                    }
                }
                mode local
            }
            client-ip-pool {
                start 10.10.130.1
                stop 10.10.130.12
            }
            outside-address 190.2.46.194
        }
    }
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "wanloadbalance@1:serial@1:dhcp-server@4:dhcp-relay@1:nat@3:cluster@1:firewall@3:webgui@1:ipsec@1:quagga@1:vrrp@1" === */
/* Release version: VC5.0.0 */
