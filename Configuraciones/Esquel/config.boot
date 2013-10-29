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
        address 200.63.154.122/30
        description Wan_TASA
        duplex full
        hw-id 34:40:b5:89:68:f8
        smp_affinity auto
        speed 100
    }
    ethernet eth1 {
        address 190.114.182.1/24
        address 10.26.128.1/24
        description Lan_TPP
        duplex auto
        hw-id 34:40:b5:89:68:f9
        smp_affinity auto
        speed auto
        vif 10 {
            address 172.16.0.1/24
        }
        vif 20 {
            address 10.20.128.1/24
        }
        vif 30 {
            address 10.30.128.1/24
        }
    }
    loopback lo {
    }
}
protocols {
    bgp 52232 {
        neighbor 200.63.154.121 {
            remote-as 22927
        }
        network 190.114.182.0/24 {
        }
    }
    static {
        route 0.0.0.0/0 {
            next-hop 200.63.154.121 {
            }
        }
        route 10.226.101.0/24 {
            next-hop 10.26.128.101 {
            }
        }
        route 10.226.102.0/24 {
            next-hop 10.26.128.102 {
            }
        }
        route 10.226.103.0/24 {
            next-hop 10.26.128.103 {
            }
        }
        route 10.226.104.0/24 {
            next-hop 10.26.128.104 {
            }
        }
        route 10.226.105.0/24 {
            next-hop 10.26.128.105 {
            }
        }
    }
}
service {
    snmp {
        community tppsa {
            authorization ro
            network 10.10.128.0/17
        }
        contact Email:ngn@tpp.com.ar
        description Vyatta-Esquel
        location Nodo-Esquel
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
    host-name Vyatta-Esquel
    login {
        user vyatta {
            authentication {
                encrypted-password $1$GfJrFnef$Q3NwktGcQkJirv41RjPM2.
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
    time-zone GMT
}
vpn {
    ipsec {
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
        ike-group IKE-1ESQ {
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
            interface eth1
        }
        site-to-site {
            peer 190.2.46.194 {
                authentication {
                    mode pre-shared-secret
                    pre-shared-secret tppvpneq
                }
                connection-type initiate
                ike-group IKE-1ESQ
                local-address 190.114.182.1
                tunnel 1 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ESQ
                    local {
                        prefix 10.26.128.0/24
                    }
                    remote {
                        prefix 10.10.128.0/17
                    }
                }
                tunnel 2 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ESQ
                    local {
                        prefix 10.26.128.0/24
                    }
                    remote {
                        prefix 192.168.0.0/16
                    }
                }
                tunnel 3 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ESQ
                    local {
                        prefix 10.226.0.0/16
                    }
                    remote {
                        prefix 10.10.128.0/17
                    }
                }
                tunnel 4 {
                    allow-nat-networks disable
                    allow-public-networks disable
                    esp-group ESP-1ESQ
                    local {
                        prefix 10.226.0.0/16
                    }
                    remote {
                        prefix 192.168.0.0/16
                    }
                }
            }
        }
    }
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "cluster@1:config-management@1:conntrack-sync@1:conntrack@1:dhcp-relay@1:dhcp-server@4:firewall@5:ipsec@4:nat@4:qos@1:quagga@2:system@6:vrrp@1:wanloadbalance@3:webgui@1:webproxy@1:zone-policy@1" === */
/* Release version: VC6.6R1 */
