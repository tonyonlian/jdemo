package com.tongyl.example.jdemoenummybaits;

import com.tongyl.example.jdemoenummybaits.emum.ComputerState;
import com.tongyl.example.jdemoenummybaits.entity.Computer;
import com.tongyl.example.jdemoenummybaits.entity.ComputerExample;
import com.tongyl.example.jdemoenummybaits.mapper.ComputerMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@MapperScan("com.tongyl.example.jdemoenummybaits.mapper")
@SpringBootApplication
public class JdemoEnumMybaitsApplication  implements ApplicationRunner {
    @Autowired
    private ComputerMapper computerMapper;

	public static void main(String[] args) {
		SpringApplication.run(JdemoEnumMybaitsApplication.class, args);
	}


	private void generateArtifacts() throws Exception {
		List<String> warnings = new ArrayList<>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(
				this.getClass().getResourceAsStream("/generatorConfig.xml"));
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

	private void testComputer(){
        Computer  computer = new Computer()
                .withName("thinkpad")
                .withComputerState(ComputerState.OPEN)
                .withCreateTime( Date.from(Instant.now()))
                .withUpdateTime(Date.from(Instant.now()));
        computerMapper.insertSelective(computer);
        ComputerExample example = new ComputerExample();
        example.createCriteria().andIdEqualTo(1L);
         List<Computer> computers = computerMapper.selectByExample(example);
         computers.forEach(computer1 -> {
             log.info("Computer :{}",computer1);
         });

    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
	    log.info("开始生成代码");
		//generateArtifacts();
        testComputer();

        List<String> strArr = new ArrayList<>();
        List<Integer> intArr = new ArrayList<>();
        log.info(strArr.getClass().getName());
        log.info(intArr.getClass().getName());
        log.info("比较是否相等：{}",strArr.getClass().equals(intArr.getClass()));

        if(strArr instanceof  ArrayList<?>){
            log.info("is array instance");
        }
	}


}
