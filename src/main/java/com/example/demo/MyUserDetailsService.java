package com.example.demo;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService
    implements UserDetailsService
{

    @Override
    public UserDetails loadUserByUsername( String username )
        throws UsernameNotFoundException
    {
        if ( "bar".equals( username ) )
        {
            return new User( "bar", "bar", AuthorityUtils.createAuthorityList( "ROLE_ADMINISTRATOR" ) );
        }

        return new User( "foo", "foo", new ArrayList<>() );
    }
}
