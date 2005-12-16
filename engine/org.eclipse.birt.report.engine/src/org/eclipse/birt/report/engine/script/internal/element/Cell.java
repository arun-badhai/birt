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

package org.eclipse.birt.report.engine.script.internal.element;

import org.eclipse.birt.report.engine.api.script.ScriptException;
import org.eclipse.birt.report.engine.api.script.element.ICell;
import org.eclipse.birt.report.model.api.CellHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;

public class Cell extends ReportElement implements ICell
{

	public Cell( CellHandle handle )
	{
		super( handle );
	}

	/**
	 * Returns the cell's column span. This is the number of table or grid
	 * columns occupied by this cell.
	 * 
	 * @return the column span
	 */

	public int getColumnSpan( )
	{
		return ( ( CellHandle ) handle ).getColumnSpan( );
	}

	/**
	 * Sets the cell's column span. This is the number of table or grid columns
	 * occupied by this cell.
	 * 
	 * @param span
	 *            the column span
	 * 
	 * @throws SemanticException
	 *             if this property is locked.
	 */

	public void setColumnSpan( int span ) throws ScriptException
	{
		try
		{
			( ( CellHandle ) handle ).setColumnSpan( span );
		} catch ( SemanticException e )
		{
			throw new ScriptException( e.getLocalizedMessage( ) );
		}
	}

	/**
	 * Returns the cell's row span. This is the number of table or grid rows
	 * occupied by this cell.
	 * 
	 * @return the row span
	 */

	public int getRowSpan( )
	{
		return ( ( CellHandle ) handle ).getRowSpan( );
	}

	/**
	 * Sets the cell's row span. This is the number of table or grid rows
	 * occupied by this cell.
	 * 
	 * @param span
	 *            the row span
	 * 
	 * @throws SemanticException
	 *             if this property is locked.
	 */

	public void setRowSpan( int span ) throws ScriptException
	{
		try
		{
			( ( CellHandle ) handle ).setRowSpan( span );
		} catch ( SemanticException e )
		{
			throw new ScriptException( e.getLocalizedMessage( ) );
		}
	}

	/**
	 * Returns the cell's drop property. This is how the cell should expand to
	 * fill the entire table or group. This property is valid only for cells
	 * within a table; but not for cells within a grid.
	 * 
	 * @return the string value of the drop property
	 * @see #setDrop(String)
	 */

	public String getDrop( )
	{
		return ( ( CellHandle ) handle ).getDrop( );
	}

	/**
	 * Sets the cell's drop property. The input value is defined in
	 * <code>DesignChoiceConstants</code> and can be one of:
	 * 
	 * <ul>
	 * <li>DROP_TYPE_NONE</li>
	 * <li>DROP_TYPE_DETAIL</li>
	 * <li>DROP_TYPE_ALL</li>
	 * </ul>
	 * 
	 * <p>
	 * 
	 * Note that This property is valid only for cells within a table; but not
	 * for cells within a grid.
	 * 
	 * @param drop
	 *            the string value of the drop property
	 * 
	 * @throws SemanticException
	 *             if the property is locked or the input value is not one of
	 *             the above.
	 * 
	 * @see #getDrop()
	 */

	public void setDrop( String drop ) throws ScriptException
	{
		try
		{
			( ( CellHandle ) handle ).setDrop( drop );
		} catch ( SemanticException e )
		{
			throw new ScriptException( e.getLocalizedMessage( ) );
		}
	}

	/**
	 * Returns the cell's column property. The return value gives the column in
	 * which the cell starts. Columns are numbered from 1.
	 * 
	 * @return the column index, starting from 1.
	 */

	public int getColumn( )
	{
		return ( ( CellHandle ) handle ).getColumn( );
	}

	/**
	 * Sets the cell's column property. The input value gives the column in
	 * which the cell starts. Columns are numbered from 1.
	 * 
	 * @param column
	 *            the column index, starting from 1.
	 * 
	 * @throws SemanticException
	 *             if this property is locked.
	 */

	public void setColumn( int column ) throws ScriptException
	{
		try
		{
			( ( CellHandle ) handle ).setColumn( column );
		} catch ( SemanticException e )
		{
			throw new ScriptException( e.getLocalizedMessage( ) );
		}
	}

	/**
	 * Returns the cell's height.
	 * 
	 * @return the cell's height
	 */

	public String getHeight( )
	{
		return ( ( CellHandle ) handle ).getHeight( ).getStringValue( );
	}

	/**
	 * Returns the cell's width.
	 * 
	 * @return the cell's width
	 */

	public String getWidth( )
	{
		return ( ( CellHandle ) handle ).getWidth( ).getStringValue( );
	}

}
