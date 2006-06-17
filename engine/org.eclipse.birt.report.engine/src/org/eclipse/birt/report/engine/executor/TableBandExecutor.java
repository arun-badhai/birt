
package org.eclipse.birt.report.engine.executor;

import org.eclipse.birt.report.engine.content.IContent;
import org.eclipse.birt.report.engine.content.ITableBandContent;
import org.eclipse.birt.report.engine.ir.RowDesign;
import org.eclipse.birt.report.engine.ir.TableBandDesign;

public class TableBandExecutor extends StyledItemExecutor
{

	protected TableBandExecutor( ExecutorManager manager )
	{
		super( manager );
	}

	public IContent execute( )
	
	{
		// start table band
		TableBandDesign bandDesign = (TableBandDesign) getDesign( );
		ITableBandContent bandContent = report.createTableBandContent( );
		setContent(bandContent);

		restoreResultSet( );
		initializeContent( bandDesign, bandContent );
		
		startTOCEntry( bandContent );
		if (emitter != null)
		{
			emitter.startTableBand( bandContent );
		}
		
		// prepare to execute the row in the band
		currentRow = 0;

		return content;
	}

	public void close( )
	{
		ITableBandContent bandContent = (ITableBandContent)getContent();
		if (emitter != null)
		{
			emitter.endTableBand( bandContent );
		}
		finishTOCEntry( );
	}

	int currentRow;

	public boolean hasNextChild( )
	{
		TableBandDesign bandDesign = (TableBandDesign) getDesign( );
		return currentRow < bandDesign.getRowCount( );
	}

	public IReportItemExecutor getNextChild( )
	{
		TableBandDesign bandDesign = (TableBandDesign) getDesign( );
		//TableItemExecutor tableExecutor = (TableItemExecutor) getParent( );

		if ( currentRow < bandDesign.getRowCount( ) )
		{
			RowDesign rowDesign = bandDesign.getRow( currentRow++ );
			RowExecutor rowExecutor = (RowExecutor) manager.createExecutor(
					this, rowDesign );
			rowExecutor.setRowId( tableExecutor.rowId++ );
			if ( bandDesign.getBandType( ) == TableBandDesign.GROUP_HEADER && currentRow == 0 )
			{
				//this row is the first row in that group
				rowExecutor.startOfGroup = true;
			}
			return rowExecutor;
		}
		return null;
	}

	TableItemExecutor tableExecutor;

	void setTableExecutor( TableItemExecutor tableExecutor )
	{
		this.tableExecutor = tableExecutor;
	}
}
