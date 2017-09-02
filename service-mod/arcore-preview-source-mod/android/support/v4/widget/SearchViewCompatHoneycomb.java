package android.support.v4.widget;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;

class SearchViewCompatHoneycomb
{
  public static CharSequence getQuery(View paramView)
  {
    return ((SearchView)paramView).getQuery();
  }
  
  public static boolean isIconified(View paramView)
  {
    return ((SearchView)paramView).isIconified();
  }
  
  public static boolean isQueryRefinementEnabled(View paramView)
  {
    return ((SearchView)paramView).isQueryRefinementEnabled();
  }
  
  public static boolean isSubmitButtonEnabled(View paramView)
  {
    return ((SearchView)paramView).isSubmitButtonEnabled();
  }
  
  public static Object newOnCloseListener(OnCloseListenerCompatBridge paramOnCloseListenerCompatBridge)
  {
    new SearchView.OnCloseListener()
    {
      public boolean onClose()
      {
        return this.val$listener.onClose();
      }
    };
  }
  
  public static Object newOnQueryTextListener(OnQueryTextListenerCompatBridge paramOnQueryTextListenerCompatBridge)
  {
    new SearchView.OnQueryTextListener()
    {
      public boolean onQueryTextChange(String paramAnonymousString)
      {
        return this.val$listener.onQueryTextChange(paramAnonymousString);
      }
      
      public boolean onQueryTextSubmit(String paramAnonymousString)
      {
        return this.val$listener.onQueryTextSubmit(paramAnonymousString);
      }
    };
  }
  
  public static View newSearchView(Context paramContext)
  {
    return new SearchView(paramContext);
  }
  
  public static void setIconified(View paramView, boolean paramBoolean)
  {
    ((SearchView)paramView).setIconified(paramBoolean);
  }
  
  public static void setMaxWidth(View paramView, int paramInt)
  {
    ((SearchView)paramView).setMaxWidth(paramInt);
  }
  
  public static void setOnCloseListener(Object paramObject1, Object paramObject2)
  {
    ((SearchView)paramObject1).setOnCloseListener((SearchView.OnCloseListener)paramObject2);
  }
  
  public static void setOnQueryTextListener(Object paramObject1, Object paramObject2)
  {
    ((SearchView)paramObject1).setOnQueryTextListener((SearchView.OnQueryTextListener)paramObject2);
  }
  
  public static void setQuery(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    ((SearchView)paramView).setQuery(paramCharSequence, paramBoolean);
  }
  
  public static void setQueryHint(View paramView, CharSequence paramCharSequence)
  {
    ((SearchView)paramView).setQueryHint(paramCharSequence);
  }
  
  public static void setQueryRefinementEnabled(View paramView, boolean paramBoolean)
  {
    ((SearchView)paramView).setQueryRefinementEnabled(paramBoolean);
  }
  
  public static void setSearchableInfo(View paramView, ComponentName paramComponentName)
  {
    paramView = (SearchView)paramView;
    paramView.setSearchableInfo(((SearchManager)paramView.getContext().getSystemService("search")).getSearchableInfo(paramComponentName));
  }
  
  public static void setSubmitButtonEnabled(View paramView, boolean paramBoolean)
  {
    ((SearchView)paramView).setSubmitButtonEnabled(paramBoolean);
  }
  
  static abstract interface OnCloseListenerCompatBridge
  {
    public abstract boolean onClose();
  }
  
  static abstract interface OnQueryTextListenerCompatBridge
  {
    public abstract boolean onQueryTextChange(String paramString);
    
    public abstract boolean onQueryTextSubmit(String paramString);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/widget/SearchViewCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */