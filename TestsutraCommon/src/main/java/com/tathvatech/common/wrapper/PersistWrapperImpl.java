package com.tathvatech.common.wrapper;

import com.tathvatech.common.dao.GenericJpaDao;
import com.tathvatech.common.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.context.ApplicationContext;

import java.util.List;


@Repository
public class PersistWrapperImpl implements PersistWrapper {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ApplicationContext context;

	@Override
	public AbstractEntity readByPrimaryKey(Class <? extends AbstractEntity> objectClass, long id)
	{
		return context.getBean(GenericJpaDao.class).findOne(objectClass, id);
	}

	@Override
	public <T> List<T> readList(final Class<T> objectClass, final String sql, final Object...parameters)
	{
		RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(objectClass);
		return jdbcTemplate.query(sql, rowMapper, parameters);
	}

	public	List<? extends AbstractEntity> readAll(final Class<? extends AbstractEntity> objectClass)
	{
		return context.getBean(GenericJpaDao.class).findAll(objectClass);
	}

	@Override
	public long createEntity(AbstractEntity inObject) throws Exception
	{
		AbstractEntity e = context.getBean(GenericJpaDao.class).create(inObject);
		return e.getPk();
	}

	@Override
	public AbstractEntity update(AbstractEntity inObject) throws Exception
	{
		return context.getBean(GenericJpaDao.class).update(inObject);
	}

	public void delete(AbstractEntity inObject) throws Exception
	{
		context.getBean(GenericJpaDao.class).delete(inObject);
	}

//   public long createEntityBk(Object inObject) throws Exception
//    {
//		String tableName = inObject.getClass().getAnnotation(Table.class).name();
//
//		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
//		          .withTableName(tableName)
//		          .usingGeneratedKeyColumns("pk");
//
//		return simpleJdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(inObject)).longValue();
//    }
	
//	public void updateBk(Object inObject)
//	{
//		String tableName = inObject.getClass().getAnnotation(Table.class).name();
//
//		List<Object> values = new ArrayList<Object>();
//		List<Integer> argTypes = new ArrayList<Integer>();
//
//		String keyColumn = "pk";
//
//		BeanPropertySqlParameterSource pSource = new BeanPropertySqlParameterSource(inObject);
//		String[] paramNames = pSource.getParameterNames();
//
//		StringBuilder sb = new StringBuilder();
//		sb.append("update ").append(tableName).append(" set ");
//
//		String coma = "";
//		for (int i = 0; i < paramNames.length; i++) {
//			if("class".equals(paramNames[i]))
//				continue;
//			if(keyColumn.equals(paramNames[i]))
//				continue;
//
//			Object paramValue = pSource.getValue(paramNames[i]);
//			if(paramValue != null)
//			{
//				sb.append(coma);
//				sb.append(paramNames[i] + "= ? ");
//				coma = ", ";
//				values.add(pSource.getValue(paramNames[i]));
//				argTypes.add(pSource.getSqlType(paramNames[i]));
//			}
//			else
//			{
//				sb.append(coma);
//				sb.append(paramNames[i] + "= null ");
//				coma = ", ";
//			}
//		}
//		sb.append(" where ").append(keyColumn).append(" = ? ");
//		values.add(pSource.getValue(keyColumn));
//		argTypes.add(pSource.getSqlType(keyColumn));
//		System.out.println(sb.toString());
//
//		jdbcTemplate.update(sb.toString(), values.toArray(), argTypes.toArray(new Integer[] {}));
//
//	}
}
