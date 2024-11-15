package cn.xuyj.springboot.example.test.service.impl;

import cn.xuyj.springboot.example.test.domain.Giser;
import cn.xuyj.springboot.example.test.service.GiserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 11:15
 */
@Service
public class GiserServiceImpl extends BaseService<Giser> implements GiserService {

    @Override
    public Giser findByName(String name) {
        Example example = new Example(Giser.class);
        example.createCriteria().andEqualTo("name", name);
        List<Giser> users = this.selectByExample(example);
        if (users.size() > 0)
            return users.get(0);
        else
            return null;
    }

    @Override
    public void saveGiser(Giser giser) {
        giser.setId(this.getSequence("seq_giser"));
        giser.setCreateTime(new Date());
        this.save(giser);
    }
}
