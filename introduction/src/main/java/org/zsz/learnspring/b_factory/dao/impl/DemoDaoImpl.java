package org.zsz.learnspring.b_factory.dao.impl;

import java.util.Arrays;
import java.util.List;
import org.zsz.learnspring.b_factory.dao.DemoDao;

/**
 * @author Zhang Shengzhe
 * @create 2022-10-26 14:45
 */
public class DemoDaoImpl implements DemoDao {

  @Override
  public List<String> findAll() {
    return Arrays.asList("aaa", "bbb", "ccc");
  }

}
