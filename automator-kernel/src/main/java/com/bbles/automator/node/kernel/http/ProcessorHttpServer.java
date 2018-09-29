package com.bbles.automator.node.kernel.http;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.config.ProcessorConstants;
import com.bbles.automator.node.kernel.http.servlet.LogServletHandler;
import com.bbles.automator.node.kernel.processor.Processor;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Responsible for sending data of log to use on time they ask about
 * them
 */
public class ProcessorHttpServer extends Server {
  private Processor processor;

  public ProcessorHttpServer(Processor processor, Configuration config) {
    super(
        config.get(ProcessorConstants.PROCESSOR_HTTP_SERVER_PORT,
            ProcessorConstants.DEFAULT_PROCESSOR_HTTP_SERVER_PORT)
    );
    this.processor = processor;
    initRequestHandler();
  }

  /**
   * Instantiate request asked by the clients
   */
  private void initRequestHandler() {
    ServletHandler handler = new ServletHandler();
    handler.addServletWithMapping(LogServletHandler.class, "/logs");
    setHandler(handler);
  }
}
