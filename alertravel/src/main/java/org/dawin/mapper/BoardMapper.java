package org.dawin.mapper;

import java.util.List;

import org.dawin.domain.BoardVO;
import org.dawin.domain.Criteria;

public interface BoardMapper {
	
	//페이징 처리
	public int getTotalCount(Criteria cri);
	
	// 게시글 목록 추출
	public List<BoardVO> getList(Criteria cri);

    // 게시글 상세 조회
    public BoardVO read(Long postId);

    // 게시글 등록
    public void insert(BoardVO board);
    

    // 게시글 수정
    public int update(BoardVO board);

    // 게시글 삭제
    public int delete(Long postId);

}
