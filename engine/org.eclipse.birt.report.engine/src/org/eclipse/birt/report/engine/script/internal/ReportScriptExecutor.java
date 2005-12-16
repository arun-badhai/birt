/*******************************************************************************
 * Copyright (c) 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.engine.script.internal;

import java.util.logging.Level;

import org.eclipse.birt.report.model.api.ReportDesignHandle;
import org.eclipse.birt.report.engine.api.script.element.IReportDesign;
import org.eclipse.birt.report.engine.api.script.eventhandler.IReportEventHandler;
import org.eclipse.birt.report.engine.executor.ExecutionContext;
import org.eclipse.birt.report.engine.script.internal.element.ReportDesign;

public class ReportScriptExecutor extends ScriptExecutor
{

	public static void handleInitialize( ReportDesignHandle report,
			ExecutionContext context )
	{
		try
		{
			if ( handleJS( null, report.getInitialize( ), context ).didRun( ) )
				return;
			IReportEventHandler eh = ( IReportEventHandler ) getInstance( report );
			if ( eh != null )
				eh.initialize( context.getReportContext( ) );
		} catch ( Exception e )
		{
			log.log( Level.WARNING, e.getMessage( ), e );
		}
	}

	public static void handleBeforeFactory( ReportDesignHandle report,
			ExecutionContext context )
	{
		try
		{
			IReportDesign reportDesign = new ReportDesign( report );
			// TODO: Wrap report
			if ( handleJS( reportDesign, report.getBeforeFactory( ), context )
					.didRun( ) )
				return;
			IReportEventHandler eh = ( IReportEventHandler ) getInstance( report );
			if ( eh != null )
				eh.beforeFactory( reportDesign, context.getReportContext( ) );
		} catch ( Exception e )
		{
			log.log( Level.WARNING, e.getMessage( ), e );
		}
	}

	public static void handleAfterFactory( ReportDesignHandle report,
			ExecutionContext context )
	{
		try
		{
			if ( handleJS( null, report.getAfterFactory( ), context ).didRun( ) )
				return;
			IReportEventHandler eh = ( IReportEventHandler ) getInstance( report );
			if ( eh != null )
				eh.afterFactory( context.getReportContext( ) );
		} catch ( Exception e )
		{
			log.log( Level.WARNING, e.getMessage( ), e );
		}
	}

	public static void handleBeforeOpenDoc( ReportDesignHandle report,
			ExecutionContext context )
	{
		try
		{
			if ( handleJS( null, report.getBeforeOpenDoc( ), context ).didRun( ) )
				return;
			IReportEventHandler eh = ( IReportEventHandler ) getInstance( report );
			if ( eh != null )
				eh.beforeOpenDoc( context.getReportContext( ) );
		} catch ( Exception e )
		{
			log.log( Level.WARNING, e.getMessage( ), e );
		}
	}

	public static void handleAfterOpenDoc( ReportDesignHandle report,
			ExecutionContext context )
	{
		try
		{
			if ( handleJS( null, report.getAfterOpenDoc( ), context ).didRun( ) )
				return;
			IReportEventHandler eh = ( IReportEventHandler ) getInstance( report );
			if ( eh != null )
				eh.afterOpenDoc( context.getReportContext( ) );
		} catch ( Exception e )
		{
			log.log( Level.WARNING, e.getMessage( ), e );
		}
	}

	public static void handleBeforeCloseDoc( ReportDesignHandle report,
			ExecutionContext context )
	{
		try
		{
			if ( handleJS( null, report.getBeforeCloseDoc( ), context )
					.didRun( ) )
				return;
			IReportEventHandler eh = ( IReportEventHandler ) getInstance( report );
			if ( eh != null )
				eh.beforeCloseDoc( context.getReportContext( ) );
		} catch ( Exception e )
		{
			log.log( Level.WARNING, e.getMessage( ), e );
		}
	}

	public static void handleAfterCloseDoc( ReportDesignHandle report,
			ExecutionContext context )
	{
		try
		{
			if ( handleJS( null, report.getAfterCloseDoc( ), context ).didRun( ) )
				return;
			IReportEventHandler eh = ( IReportEventHandler ) getInstance( report );
			if ( eh != null )
				eh.afterCloseDoc( context.getReportContext( ) );
		} catch ( Exception e )
		{
			log.log( Level.WARNING, e.getMessage( ), e );
		}
	}

	public static void handleBeforeRender( ReportDesignHandle report,
			ExecutionContext context )
	{
		try
		{
			if ( handleJS( null, report.getBeforeRender( ), context ).didRun( ) )
				return;
			IReportEventHandler eh = ( IReportEventHandler ) getInstance( report );
			if ( eh != null )
				eh.beforeRender( context.getReportContext( ) );
		} catch ( Exception e )
		{
			log.log( Level.WARNING, e.getMessage( ), e );
		}
	}

	public static void handleAfterRender( ReportDesignHandle report,
			ExecutionContext context )
	{
		try
		{
			if ( handleJS( null, report.getAfterRender( ), context ).didRun( ) )
				return;
			IReportEventHandler eh = ( IReportEventHandler ) getInstance( report );
			if ( eh != null )
				eh.afterRender( context.getReportContext( ) );
		} catch ( Exception e )
		{
			log.log( Level.WARNING, e.getMessage( ), e );
		}
	}
}
