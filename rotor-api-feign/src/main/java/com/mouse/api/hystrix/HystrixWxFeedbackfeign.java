package com.mouse.api.hystrix;

import com.mouse.api.commons.req.FeedbackReq;
import com.mouse.api.feign.Feedbackfeign;
import com.mouse.core.base.R;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ; lidongdong
 * @Description 意见反馈服务 熔断器
 * @Date 2020-01-25
 */
@Slf4j
@Component
public class HystrixWxFeedbackfeign implements FallbackFactory<Feedbackfeign> {
    @Override
    public Feedbackfeign create(Throwable throwable) {
        log.error("错误信息：", throwable);
        return new Feedbackfeign() {
            @Override
            public Object submit(Integer userId, FeedbackReq param) {
                return R.error();
            }
        };
    }
}