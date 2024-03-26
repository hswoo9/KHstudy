package com.kh.mybatis;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class App {
//	private static Logger log = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	
        System.out.println( "Hello World!" );
        log.info("Hello SLF4J");
        log.debug("Hello SLF4J - debug");
        
//        int count = 0;
//        SqlSession session = getSession();
//        
//        count = session.selectOne("memberMapper.selectCount");
//        
//        System.out.println("Count : " + count);
    }
}
