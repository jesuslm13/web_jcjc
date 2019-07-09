package jcjc.politicianprofile.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import jcjc.politician.entity.Politician;
import jcjc.politicianprofile.entity.PoliticianProfileEntity;

public interface PoliticianProfileMapper {

//	private int politician_no;
//	private int politician_num;
//	private String politician_kor_name;
//	private String politician_hj_name;
//	private String politician_eng_name;
//	private String bth_date;
//	private String poly_name;
//	private String orig_name;
//	private String shrt_name;
//	private String reele_gbn_name;
//	private String election_name;
//	private String assem_tel;
//	private String assem_homep;
//	private String assem_email;
//	private String hbby_cd;
//	private String exam_cd;
//	private String politician_jpg_link;
	
	@Insert("insert into politician values ("
			+ "#{politician_no}, "
			+ "#{politician_num}, "
			+ "#{politician_kor_name}, "
			+ "#{politician_hj_name}, "
			+ "#{politician_eng_name}, "
			+ "to_date(#{bth_date},'yyyymmdd'), "
			+ "#{poly_name}, "
			+ "#{orig_name}, "
			+ "#{shrt_name}, "
			+ "#{reele_gbn_name}, "
			+ "#{election_name}, "
			+ "#{assem_tel}, "
			+ "#{assem_homep}, "
			+ "#{assem_email}, "
			+ "#{hbby_cd}, "
			+ "#{exam_cd}, "
			+ "#{politician_jpg_link})"
			)
	public int insertProfile(PoliticianProfileEntity entity);

	// Politician delete
	@Delete("delete from politician")
	public int deleteProfile();

//	private int politician_no;
//	private String politician_num;
//	private String politician_kor_name;
//	private String politician_hj_name;
//	private String politician_eng_name;
//	private String politician_reele_gbn_nm;
//	private String politician_location;
//	private String politician_jpg_link;
/*	
	@Insert("insert into politician values ("
			+ "#{politician_no},"
			+ "#{politician_num},"
			+ "#{politician_kor_name},"
			+ "#{politician_hj_name},"
			+ "#{politician_eng_name},"
			+ "#{politician_reele_gbn_nm},"
			+ "#{politician_location},"
			+ "#{politician_jpg_link})"
			)
	public int insertPolitician(Politician entity);
*/
	@Update("update politician set politician_no=#{politician_no} where politician_kor_name=#{politician_kor_name} and orig_name=#{orig_name}")
	public int updatePoliticianNo(@Param("politician_kor_name")String politician_kor_name, @Param("orig_name")String orig_name, @Param("politician_no")Integer politician_no);

	@Update("update politician set politician_num=#{politician_num} where politician_kor_name=#{politician_kor_name} and orig_name=#{orig_name}")
	public int updatePoliticianNum(@Param("politician_kor_name")String politician_kor_name, @Param("orig_name")String orig_name, @Param("politician_num")Integer politician_num);

	@Update("update politician set politician_jpg_link=#{politician_jpg_link} where politician_kor_name=#{politician_kor_name} and orig_name=#{orig_name}")
	public int updatePoliticianJpgLinkList(@Param("politician_kor_name")String politician_kor_name, @Param("orig_name")String orig_name, @Param("politician_jpg_link")String politician_jpg_link);
	
}
