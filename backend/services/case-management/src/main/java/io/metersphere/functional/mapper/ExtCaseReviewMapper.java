package io.metersphere.functional.mapper;

import io.metersphere.functional.domain.CaseReview;
import io.metersphere.functional.dto.CaseReviewDTO;
import io.metersphere.functional.request.CaseReviewBatchRequest;
import io.metersphere.functional.request.CaseReviewPageRequest;
import io.metersphere.project.dto.ModuleCountDTO;
import io.metersphere.system.interceptor.BaseConditionFilter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guoyuqi
 */
public interface ExtCaseReviewMapper {

    List<CaseReview> checkCaseByModuleIds(@Param("moduleIds") List<String> deleteIds);

    Long getPos(@Param("projectId") String projectId);

    @BaseConditionFilter
    List<CaseReviewDTO> list(@Param("request") CaseReviewPageRequest request);

    Long getPrePos(@Param("projectId") String projectId, @Param("basePos") Long basePos);

    Long getLastPos(@Param("projectId") String projectId, @Param("basePos") Long basePos);

    @BaseConditionFilter
    List<String> getIds(@Param("request") CaseReviewBatchRequest request, @Param("projectId") String projectId);

    void batchMoveModule(@Param("request") CaseReviewBatchRequest request, @Param("ids") List<String> ids, @Param("userId") String userId);

    @BaseConditionFilter
    List<ModuleCountDTO> countModuleIdByKeywordAndFileType(@Param("request") CaseReviewPageRequest request);

    @BaseConditionFilter
    long caseCount(@Param("request") CaseReviewPageRequest request);


    String getReviewPassRule(@Param("id") String id);
}
