package com.conymind.backend.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class FirebaseUserDetails(private val email: String, private val uid: String) : UserDetails {

    private val authorities: Collection<GrantedAuthority> = listOf(SimpleGrantedAuthority("USER"))

    override fun getAuthorities(): Collection<GrantedAuthority> = authorities

    override fun getPassword(): String = ""

    override fun getUsername(): String = email

    override fun isAccountNonExpired(): Boolean = true  // 계정 만료 관리는 필요 없으면 항상 true

    override fun isAccountNonLocked(): Boolean = true  // 계정 잠김 관리는 필요 없으면 항상 true

    override fun isCredentialsNonExpired(): Boolean = true  // 자격 증명 만료 관리는 필요 없으면 항상 true

    override fun isEnabled(): Boolean = true  // 계정 활성화 관리는 필요 없으면 항상 true
}