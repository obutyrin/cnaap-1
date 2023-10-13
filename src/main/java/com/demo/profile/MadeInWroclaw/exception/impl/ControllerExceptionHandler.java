package com.demo.profile.MadeInWroclaw.exception.impl;

import com.gringotts.foundation.core.utils.CommonStatusCode;
import com.gringotts.foundation.core.utils.exception.ExceptionHandler;
import com.gringotts.foundation.core.utils.exception.ProblemUtil;
import com.gringotts.foundation.core.utils.execution.ServiceContextUtil;
import com.gringotts.foundation.core.utils.logging.LoggingUtil;
import org.aspectj.lang.JoinPoint;
import org.zalando.problem.Status;
import org.zalando.problem.ThrowableProblem;

public class ControllerExceptionHandler
    implements ExceptionHandler, ServiceContextUtil, ProblemUtil, LoggingUtil {

  @Override
  public void handleException(JoinPoint joinPoint, Throwable error) {
    // HINT: your code goes here...
    if (error instanceof ThrowableProblem) {
      throw (ThrowableProblem) error;
    } else {
      getErrorLogMessageBuilder(
              CommonStatusCode.INTERNAL_SERVICE_ERROR.getCode(),
              CommonStatusCode.INTERNAL_SERVICE_ERROR.getDescription(),
              error)
          .build()
          .logAsError();
      throw createProblem(
          Status.INTERNAL_SERVER_ERROR.getStatusCode(),
          CommonStatusCode.INTERNAL_SERVICE_ERROR.getCode(),
          CommonStatusCode.INTERNAL_SERVICE_ERROR.getDescription(),
          error);
    }
  }
}
